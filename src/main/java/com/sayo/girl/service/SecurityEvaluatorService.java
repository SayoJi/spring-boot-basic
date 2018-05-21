package com.sayo.girl.service;


import com.sayo.girl.domain.AppContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

public class SecurityEvaluatorService implements PermissionEvaluator {
    private static Log LOG = LogFactory.getLog(SecurityEvaluatorService.class);

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if ("PUBLIC".equals(permission)) {
            return true;
        }

        LOG.debug("hasPermission \n" + targetDomainObject + "\n" + permission);
        if (AppContext.getUserFunctionPointsList().contains(permission)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId,
                                 String targetType, Object permission) {
        throw new RuntimeException("This method is not supported.");
    }
}

