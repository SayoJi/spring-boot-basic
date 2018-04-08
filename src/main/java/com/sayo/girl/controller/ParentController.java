package com.sayo.girl.controller;

import com.sayo.girl.domain.Child;
import com.sayo.girl.domain.Parent;
import com.sayo.girl.repository.ChildRepository;
import com.sayo.girl.repository.ParentRepository;
import com.sayo.girl.service.ChildServiceIf;
import com.sayo.girl.service.ParentService;
import com.sayo.girl.valueobject.ValidateForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Shuangyao
 * 7:47 2018/1/18
 */

@RestController
public class ParentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ParentController.class);

    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ParentService parentServiceProdImp;

    @Autowired
    private ChildServiceIf childServiceIf;
    @Autowired
    private ChildRepository childRepository;

    // post parent
    @PostMapping(value = "/parent/add")
    public void AddParent(){
        Parent parent = new Parent();
        parent.setHomeNo(22);
        parent.setIncome(123456);
        parent.setJob("Doctor");
        parent.setName("Liu");

        Child child1 = new Child();
        child1.setHomeNo(22);
        child1.setName("sayo");
        parent.getChildList().add(child1);
        this.parentRepository.save(parent);

        Parent parent2 = new Parent();
        parent.setHomeNo(23);
        parent2.setName("Su");
        Child child2 = new Child();
        child2.setHomeNo(23);
        child2.setName("Xue");
//        child2.setParent(parent);

        this.childRepository.save(child2);
    }

    @GetMapping(value = "/parent/{homeNo}")
    public Parent getParentByHomeNo(@PathVariable("homeNo") Integer homeNo){
        Parent parent =  parentServiceProdImp.queryParentByHomeNo(homeNo);
        LOGGER.error("environment={}:", childServiceIf.tsetMutiEnvironmentConfig());
        return parent;
    }

    @PostMapping(value = "/testVidate")
    public boolean validate(@RequestBody ValidateForm validateForm) {
        System.out.printf("++++++++++++++++++++===========" + validateForm);

        return true;
    }

}
