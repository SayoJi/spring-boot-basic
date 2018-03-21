package com.sayo.girl.controller;

import com.sayo.girl.valueobject.TestRoleView;
import com.sayo.girl.valueobject.User;
import com.sayo.girl.valueobject.UserForm;
import org.slf4j.LoggerFactory;
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
