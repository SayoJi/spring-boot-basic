package com.sayo.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Shuangyao
 * 22:55 2018/1/1
 */
@Component
@ConfigurationProperties(prefix = "girl") //match to properties config
public class GirlProperties {
    private String cupSize;
    private  Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
