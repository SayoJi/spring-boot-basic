package com.sayo.girl.controller;

import com.sayo.girl.valueobject.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Shuangyao
 * 22:13 2018/1/29
 */

@RestController
public class UserController {

    @GetMapping(value = "/user")
    public User queryUser() {
        User user = new User();
        user.setUserId("userId01");
        user.setUserName("userName01");

//        user.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
        user.setLastUpdateTime(new Date());
        return user;
    }

    @PutMapping(value = "/updateUser")
    public User updateUser(User user) {
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setLastUpdateTime(user.getLastUpdateTime());
        return user1;
    }

}
