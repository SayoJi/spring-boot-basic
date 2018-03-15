package com.sayo.girl.controller;

import com.sayo.girl.valueobject.User;
import com.sayo.girl.valueobject.UserForm;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Logger;

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
    public User updateUser(@RequestBody User user) {
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setLastUpdateTime(user.getLastUpdateTime());
        System.out.println(user1);
        return user1;
    }

    @PostMapping(value = "/addUser")
    public boolean addUser(@RequestBody @Valid UserForm userForm) {
        System.out.println("===========================" + userForm);
        return true;
    }

}
