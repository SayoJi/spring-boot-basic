package com.sayo.girl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Shuangyao
 * 22:38 2018/1/23
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(info())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sayo.girl.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo info() {
        return new ApiInfoBuilder()
                .title("Swagger Demo")
                .description("just a spring boot demo api.")
                .version("1.0")
                .build();
    }
}
