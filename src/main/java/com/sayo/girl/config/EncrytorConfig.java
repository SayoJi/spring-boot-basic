package com.sayo.girl.config;

import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncrytorConfig {
    @Bean
    public StandardPBEStringEncryptor standardPBEStringEncryptor() {
        EnvironmentStringPBEConfig environmentStringPBEConfig = new EnvironmentStringPBEConfig();
        environmentStringPBEConfig.setAlgorithm("PBEWithMD5AndDES");
        environmentStringPBEConfig.setPassword("PRUDENTIALHKWEB");

        StandardPBEStringEncryptor standardPBEStringEncryptor = new StandardPBEStringEncryptor();
        standardPBEStringEncryptor.setConfig(environmentStringPBEConfig);
        return standardPBEStringEncryptor;
    }

    @Bean
    public StandardPBEByteEncryptor standardPBEByteEncryptor() {
        EnvironmentStringPBEConfig environmentStringPBEConfig = new EnvironmentStringPBEConfig();
        environmentStringPBEConfig.setAlgorithm("PBEWithMD5AndDES");
        environmentStringPBEConfig.setPassword("PRUDENTIALHKWEB");

        StandardPBEByteEncryptor standardPBEByteEncryptor = new StandardPBEByteEncryptor();
        standardPBEByteEncryptor.setConfig(environmentStringPBEConfig);
        return standardPBEByteEncryptor;
    }
}
