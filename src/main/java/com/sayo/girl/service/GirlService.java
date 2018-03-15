package com.sayo.girl.service;

import com.sayo.girl.domain.Girl;
import com.sayo.girl.enums.ResultEnum;
import com.sayo.girl.exception.GirlException;
import com.sayo.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Shuangyao
 * 22:36 2018/1/2
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void AddTwoGirls(){
        Girl sayo = new Girl();
        sayo.setAge(24);
        sayo.setCupSize("B");

        girlRepository.save(sayo);

        Girl lisa = new Girl();
        lisa.setAge(18);
        lisa.setCupSize("A");

        girlRepository.save(lisa);
    }

    public void getAge(Integer id) throws GirlException{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.PRIMARY_STUDENT);
        }else if(age < 16 && age > 10){
            throw new GirlException(ResultEnum.SENIOR_STUDENT);
        }else if(age>18){
            throw new GirlException(ResultEnum.ADULT);
        }
    }

    /**
     * test when a method with transactional call another method,
     * when the other save fail, transactional work ??
     * the answer yes, two data save failed.
     */
    @Transactional
    public void testTransactional(){
        Girl girl1 = new Girl();
        girl1.setAge(25);
        girl1.setCupSize("B");
        girl1.setMoney((double) 100);
        girlRepository.save(girl1);
        saveGirl2();
    }

    private void saveGirl2(){
        Girl girl2 = new Girl();
        girl2.setAge(19);
        girl2.setCupSize("C");
        girl2.setMoney((double)12);
        girlRepository.save(girl2);
    }
}
