package com.sayo.girl.config;


import com.sayo.girl.service.SecurityEvaluatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    /**
     * Register custom security evaluator. check {@link SecurityEvaluatorService} for details.
     *
     * @return SecurityEvaluatorService
     */
    @Bean
    public SecurityEvaluatorService securityEvaluatorService() {
        return new SecurityEvaluatorService();
    }

    /**
     * Register global configuration for Cross-origin resource sharing.
     *
     * @return WebMvcConfigurer
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new CashierMvcConfigurer();
    }

    static class CashierMvcConfigurer extends WebMvcConfigurerAdapter {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            //registry.addMapping("/**").allowedOrigins("http://localhost:9000");
            registry.addMapping("/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
        }
    }

    @Configuration
    @Order(1)
    public static class CashierWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

        @Autowired
        @Qualifier("authenticationEntryPointImpl")
        AuthenticationEntryPoint authenticationEntryPointImpl;

        @Autowired
        @Qualifier("authenticationSuccessHandler")
        AuthenticationSuccessHandler authenticationSuccessHandler;

        @Autowired
        @Qualifier("authenticationFailHandler")
        AuthenticationFailHandler authenticationFailHandler;

        @Autowired
        @Qualifier("customUserDetailsMapper")
        CustomUserDetailsMapper customUserDetailsMapper;

        @Autowired
        @Qualifier("databaseUserDetailsService")
        DatabaseUserDetailsService databaseUserDetailsService;

        @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
        @Override
        public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
        }


        /**
         * <p>Provide <strong>formLogin</strong> and <strong>httpBasic</strong> access control for online module.</p>
         * <h2>Features</h2>
         * <ul>
         *     <li>for swagger UI, just by pass security checking.</li>
         *     <li>for all url start with /pub(for public endpoint), by pass security checking.</li>
         *     <li>for all other endpoints, cannot access until authenticated.</li>
         * </ul>
         * <p>if you want to disable the checking for development, please change it to permitAll().</p>
         * <p>If httpBasic were prior to formLogin,
         * http response with code 401(Unauthorized) will return with application exception</p>
         * <p>If formLogin were prior to httpBasic,
         * http response with code 302(Found) will return with redirect url in header.</p>
         *
         * @param http httpSecurity
         * @throws Exception exception
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.addFilterBefore(new WebSecurityCorsFilter(), ChannelProcessingFilter.class);
            http
                    .csrf().disable()
                    .authorizeRequests()
                    //for swagger UI, just by pass security checking.
                    .antMatchers("/swagger-ui.html",
                            "/swagger-resources",
                            "/swagger-resources/**/*",
                            "/webjars/**/*",
                            "/*.html",
                            "/*.js",
                            "/*.jpg",
                            "/*.svg",
                            "/*.ico",
                            "/*.txt",
                            "/*.css",
                            "/",
                            "/assets/**/*",
                            "/v2/api-docs").permitAll()
                    //for all url start with /pub(for public endpoint), by pass security checking.
                    .antMatchers("/api/pub/**/*").permitAll()
                    .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    //for all other endpoints, cannot access until authenticated.
                    //if you want to disable the checking for development, please change it to permitAll().
                    .anyRequest().authenticated()
                    //login and save cookie to cookiename "curl -X POST http://localhost:8082/admin_service/login
                    // -d username=bob -d password=bobspassword -c cookiename"
                    .and().formLogin().loginProcessingUrl("/api/login").successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailHandler)
                    .and().sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .sessionAuthenticationStrategy(
                            new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl()))
                    .and().exceptionHandling()
                    .authenticationEntryPoint(authenticationEntryPointImpl)
                    .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/api/logout")).logoutSuccessUrl("/");

        }

        @Override
        @CrossOrigin
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            //DB authentication
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setUserDetailsService(databaseUserDetailsService);
            auth.authenticationProvider(daoAuthenticationProvider);

            //LDAP authentication
//             auth
//                    .ldapAuthentication().userDetailsContextMapper(customUserDetailsMapper)
//                    .contextSource()
//                    .url(SystemParams.getLdapUrl() + SystemParams.getLdapBaseDn())
//                    .managerDn(SystemParams.getLdapManagerDn())
//                    .managerPassword(SystemParams.getLdapManagerPassword())
//                    .and()
//                    .userDnPatterns(SystemParams.getLdapUserDnPattern());
        }
    }

    public static class WebSecurityCorsFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            HttpServletResponse res = (HttpServletResponse) response;
            HttpServletRequest req = (HttpServletRequest) request;
            String currentOrigin = req.getHeader("Origin");
            if (!StringUtil.isEmpty(currentOrigin)) {
                res.setHeader("Access-Control-Allow-Origin", currentOrigin);
            } else {
                res.setHeader("Access-Control-Allow-Origin", "*");
            }
            res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
            res.setHeader("Access-Control-Max-Age", "3600");
            res.setHeader("Access-Control-Allow-Credentials", "true");
            res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type," +
                    " Accept, x-requested-with, Cache-Control");
            chain.doFilter(request, res);
        }

        @Override
        public void destroy() {
        }
    }

}
