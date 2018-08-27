package com.sayo.girl.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class User extends UserBase {

    private String password;
    private Boolean locked;
    private String groupCode;
    private Boolean enableFlag;
    private List<UserRole> roles;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public Boolean getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(Boolean enableFlag) {
        this.enableFlag = enableFlag;
    }

    @ManyToMany
    @JoinTable(name = "user_user_role",
    joinColumns = @JoinColumn(name = "user_name", referencedColumnName = "user_name", updatable = false, insertable = false),
    inverseJoinColumns = @JoinColumn(name = "role_code", referencedColumnName = "role_code", updatable = false, insertable = false))
    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
