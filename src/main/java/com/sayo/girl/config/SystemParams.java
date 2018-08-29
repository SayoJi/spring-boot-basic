package com.sayo.girl.config;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Encrytor encrytor;

    private static String userName;
    private static String password;

    public static String getUserName() {
        return userName;
    }

    @Value("${userName}")
    public void setUserName(String userName) {
        SystemParams.userName = encrytor.decrypt(userName);
    }

    public static String getPassword() {
        return password;
    }

    @Value("${password}")
    public void setPassword(String password) {
        SystemParams.password = encrytor.decrypt(password);
    }
}
