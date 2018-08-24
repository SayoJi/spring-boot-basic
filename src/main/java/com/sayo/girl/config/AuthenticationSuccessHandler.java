//package com.sayo.girl.config;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * This is the program to handle the following thing after user login successfully.
// * If user login successfully, onAuthenticationSuccess function would be called.
// */
//@Service("authenticationSuccessHandler")
//public class AuthenticationSuccessHandler extends
//        SavedRequestAwareAuthenticationSuccessHandler {
//    /**
//     *  This is the function which would be called if user login successfully.
//     *  For RESTful API, server would not do any forward and redirect action
//     *
//     * @param request http servlet request
//     * @param response http servlet response
//     * @param authentication authentication information
//     */
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request,
//                                        HttpServletResponse response, Authentication authentication)
//            throws IOException, ServletException {
//        // super.onAuthenticationSuccess(request, response, authentication);
//    }
//}