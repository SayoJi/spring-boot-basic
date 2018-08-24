package com.sayo.girl.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Shuangyao
 * 15:57 2018/1/20
 */

@Configuration
@Profile("dev")
@Service
public class ChildServiceDevImp implements ChildServiceIf {



    @Override
    public String tsetMutiEnvironmentConfig() {
        return "now in dev environment.";
    }



}
