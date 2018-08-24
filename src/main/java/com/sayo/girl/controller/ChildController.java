package com.sayo.girl.controller;

import com.sayo.girl.domain.Child;
import com.sayo.girl.repository.ChildRepository;
import com.sayo.girl.service.DbAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Shuangyao
 * 15:37 2018/1/20
 */

@RestController
public class ChildController {

    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private DbAccessService dbAccessService;
    // post child
    @PostMapping(value = "/child/add")
    public Child AddChild(@RequestParam("childNo") Integer childNo,
                          @RequestParam("age") Integer age,
                          @RequestParam("education") String education,
                          @RequestParam("homeNo") Integer homeNo,
                          @RequestParam("name") String name) {
        Child child = new Child();

        child.setChildNo(childNo);
        child.setAge(age);
        child.setEducation(education);
        child.setHomeNo(homeNo);
        child.setName(name);

        return childRepository.save(child);
    }

    @GetMapping(value = "/getNameList")
    public List<String> getNameList(){
        return dbAccessService.getNameList();
    }
}
