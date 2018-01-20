package com.sayo.girl.controller;

import com.sayo.girl.domain.Parent;
import com.sayo.girl.repository.ParentRepository;
import com.sayo.girl.service.ChildServiceIf;
import com.sayo.girl.service.ParentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // post parent
    @PostMapping(value = "/parent/add")
    public Parent AddParent(@RequestParam("HomeNo") Integer homeNo,
                            @RequestParam("income") Integer income,
                            @RequestParam("job") String job,
                            @RequestParam("name") String name){
        Parent parent = new Parent();
        parent.setHomeNo(homeNo);
        parent.setIncome(income);
        parent.setJob(job);
        parent.setName(name);

        return  parentRepository.save(parent);
    }

    @GetMapping(value = "/parent/{homeNo}")
    public Parent getParentByHomeNo(@PathVariable("homeNo") Integer homeNo){
        Parent parent =  parentServiceProdImp.queryParentByHomeNo(homeNo);
        LOGGER.error("environment={}:", childServiceIf.tsetMutiEnvironmentConfig());
        return parent;
    }

}
