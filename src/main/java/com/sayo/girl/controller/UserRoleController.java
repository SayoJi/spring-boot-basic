package com.sayo.girl.controller;

import com.sayo.girl.domain.UserRole;
import com.sayo.girl.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Shuangyao
 * 22:38 2018/8/28
 */
@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping(value = "/role/add")
    public boolean addNewUserRole(@RequestBody UserRole userRole) {
        return this.userRoleService.addNewUserRole(userRole);
    }
}
