package com.sayo.girl.valueobject;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created by Shuangyao
 * 15:25 2018/2/4
 */

public class ValidateForm {
    private Integer id;
    private String name;
    private String phone;

    @Override
    public String toString() {
        return "ValidateForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
