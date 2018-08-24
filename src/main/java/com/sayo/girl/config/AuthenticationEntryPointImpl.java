//package com.sayo.girl.config;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * This is authentication entry point.
// *  If system hit any authentication exceptions, commence function would be called.
// *  For RESTful API, default return 401 error code to front end.
// */
//@Service("authenticationEntryPointImpl")
//public class AuthenticationEntryPointImpl  implements AuthenticationEntryPoint {
//    /**
//     *  This is the function which would be called if system hit any authentication exceptions.
//     *
//     * @param request http servlet request
//     * @param response http servlet response
//     * @param exception authentication exception
//     */
//    @Override
//    public void commence(HttpServletRequest request,
//                         HttpServletResponse response, AuthenticationException exception) throws IOException {
//
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//
//    }
//}
