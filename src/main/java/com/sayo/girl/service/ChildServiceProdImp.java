package com.sayo.girl.service;

import com.sayo.girl.domain.Child;
import com.sayo.girl.repository.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shuangyao
 * 8:01 2018/1/17
 */

@Configuration
@Profile("prod")
@Service
public class ChildServiceProdImp implements ChildServiceIf {

    @Autowired
    private ChildRepository childRepository;

    public List<Child> queryChildByHomeNO(Integer homeNO){
        return this.childRepository.findByHomeNo(homeNO);
    }

    @Override
    public String tsetMutiEnvironmentConfig() {
        return "now in product";
    }
}
