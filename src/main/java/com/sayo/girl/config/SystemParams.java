package com.sayo.girl.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * get some system parameters from properties file.
 */
@Component
@ConfigurationProperties
@PropertySource(value = "classpath:proj.properties")
public class SystemParams {

    private static String userName;
    private static String password;

    @Value("${userName}")
    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        SystemParams.userName = userName;
    }

    @Value("${password}")
    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        SystemParams.password = password;
    }
}
