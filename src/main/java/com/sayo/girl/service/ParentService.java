package com.sayo.girl.service;

import com.sayo.girl.domain.Parent;
import com.sayo.girl.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Shuangyao
 * 7:52 2018/1/16
 */

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public Parent queryParentByHomeNo(Integer homeNo){
        return this.parentRepository.findByHomeNo(homeNo);
    }
}
