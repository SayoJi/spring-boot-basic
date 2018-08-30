package com.sayo.girl.controller;

import com.sayo.girl.config.SystemParams;
import com.sayo.girl.service.UserService;
import com.sayo.girl.valueobject.TestRoleView;
import com.sayo.girl.valueobject.User;
import com.sayo.girl.valueobject.UserForm;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Shuangyao
 * 22:13 2018/1/29
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/query/all")
    public User queryUser() {
        System.out.println(SystemParams.getPassword());
        System.out.println(SystemParams.getUserName());
        User user = new User();
        return user;
    }

    @PutMapping(value = "/update")
    public User updateUser(@RequestBody User user) {
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setLastUpdateTime(user.getLastUpdateTime());
        System.out.println(user1);
        return user1;
    }

    @PostMapping(value = "/new")
    public boolean addUser(@RequestBody UserForm userForm) {
        return userService.addUser(userForm);
    }

    @GetMapping(value = "/getRole")
    public List<TestRoleView> getTestRoleView(){
        List<TestRoleView> testRoleViews = new ArrayList<>();

        TestRoleView testRoleView = new TestRoleView();
        testRoleView.setCode("code1");
        testRoleView.setDescription("code1 desc");
        testRoleView.setFunction("function1");
        testRoleView.setLabel("code1");

        TestRoleView testRoleView2 = new TestRoleView();
        testRoleView2.setCode("code2");
        testRoleView2.setDescription("code2 desc");
        testRoleView2.setFunction("function2");
        testRoleView2.setLabel("code2");
        testRoleView2.setChildren(testRoleView);

        testRoleViews.add(testRoleView2);

        return testRoleViews;
    }


}
