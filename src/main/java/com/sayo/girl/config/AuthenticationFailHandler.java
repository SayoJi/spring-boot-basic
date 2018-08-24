//package com.sayo.girl.config;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Service("authenticationFailHandler")
//public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//        this.returnJson(response, exception);
//    }
//
//    private void returnJson(HttpServletResponse response,
//                            AuthenticationException exception) throws IOException {
//        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        response.getWriter().println("{\"exceptionId\":\"null\",\"errorType\":null,\"messageList\":[{\"messageCode\":\"security.user_login.authentication_fail\"," +
//                "\"message\":\"LAN ID or Password is incorrect.\"}],\"serverTime\": " + System.currentTimeMillis() + "}");
//    }
//}
