package com.sayo.girl.valueobject;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by Shuangyao
 * 16:51 2018/2/4
 */
public class UserForm {

    @NotEmpty(message = "user code must enter.")
    private String userCode;
    @NotNull(message = "user name can't null.")
    private String userName;
    @Length(min = 11,max = 11,message = "phone number must 11.")
    private String phone;

    @Override
    public String toString() {
        return "UserForm{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getUserCode() {
        return userCode;
    }


    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
