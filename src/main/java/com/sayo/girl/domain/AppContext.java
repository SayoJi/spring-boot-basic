package com.sayo.girl.domain;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class AppContext {

    /**
     * This is to get user name.
     * @return user name
     */
    public static String getUserName() {
        UserContext userContext = getUserContext();
        if (userContext != null) {
            return userContext.getUsername();
        }
        return null;
    }

    /**
     * This is to get user description.
     * @return user name
     */
    public static String getUserDesc() {
        UserContext userContext = getUserContext();
        if (userContext != null) {
            return userContext.getUser().getUserDescription();
        }
        return null;
    }

    /**
     * This is to get user roles list.
     * @return user roles list
     */
    public static List<String> getUserRolesList() {
        UserContext userContext = getUserContext();
        if (userContext != null) {
            return userContext.getUserRolesList();
        }
        return new ArrayList<>();
    }

    /**
     * This is to get user function points list.
     * @return function points under current user
     */
    public static List<String> getUserFunctionPointsList() {
        UserContext userContext = getUserContext();
        if (userContext != null) {
            return userContext.getUserFunctionPointsList();
        }
        return new ArrayList<>();
    }

    private static UserContext getUserContext() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }

        Authentication authen = context.getAuthentication();

        if (authen == null) {
            return null;
        }

        Object result = authen.getPrincipal();
        if (result == null) {
            return null;
        }

        if (result instanceof UserContext) {
            return (UserContext) result;
        } else {
            return null;
        }
    }
}

