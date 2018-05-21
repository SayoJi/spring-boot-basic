package com.sayo.girl.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserBase{
    private String userName;
    private String userDescription;

    /**
     * The ID of a user that is used for authentication. It should be
     * equal to the user ID that is stored in the LDAP server.
     * @return user id
     */
    @Id
    @Column(name = "USER_NAME", unique = true, nullable = false, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * The real user full name. Usually, it is used to be displayed in screens or reports.
     * @return user name
     */
    @Column(name = "USER_DESCRIPTION", length = 200)
    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

}

