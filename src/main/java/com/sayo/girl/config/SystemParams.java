package com.sayo.girl.config;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
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

    @Value("${localUserName}")
    public void setUserName(String userName) {
        SystemParams.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    @Value("${localPassword}")
    public void setPassword(String password) {
        SystemParams.password = password;
    }
}
