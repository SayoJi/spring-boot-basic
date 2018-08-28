package com.sayo.girl.valueobject;

import java.util.List;

/**
 * Created by Shuangyao
 * 16:51 2018/2/4
 */
public class UserForm {

    private String userName;
    private String password;
    private String userDesc;

    private List<String> roleCodeList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public List<String> getRoleCodeList() {
        return roleCodeList;
    }

    public void setRoleCodeList(List<String> roleCodeList) {
        this.roleCodeList = roleCodeList;
    }
}
