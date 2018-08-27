package com.sayo.girl.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserBase{

    private String userName;
    private String userDescription;

    /**
     * The ID of a user that is used for authentication. It should be
     * equal to the user ID that is stored in the LDAP server.
     * @return user id
     */
    @Id
    @Column(name = "user_name")
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
    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

}

