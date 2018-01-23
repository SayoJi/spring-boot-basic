package com.sayo.girl.controller;

import com.sayo.girl.domain.Girl;
import com.sayo.girl.domain.RequestResult;
import com.sayo.girl.exception.GirlException;
import com.sayo.girl.repository.GirlRepository;
import com.sayo.girl.service.GirlService;
import com.sayo.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Shuangyao
 * 17:23 2018/1/2
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * get all the girls from db.
     *
     * @return query all girl from database.
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlsList() {
        logger.info("is excution in getGirlsList");
        return girlRepository.findAll();
    }

    /**
     * add a girl to db
     *
     * @param girl girl body.
     * @return when successful return a json what you post to database.
     */
    @PostMapping(value = "/girls")
    public RequestResult<Girl> AddGirl(@Valid Girl girl, BindingResult bindingResult) {
        RequestResult requestResult;
        if (bindingResult.hasErrors()) {
            requestResult = ResultUtil.error(201, bindingResult.getFieldError().getDefaultMessage());
        } else {
            requestResult = ResultUtil.success(girlRepository.save(girl));
        }
        return requestResult;
    }

    /**
     * get a girl by id
     *
     * @param id girl ID.
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }


    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> getGirlsByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /**
     * update a girl by id
     *
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("age"  ) Integer age,
                           @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    /**
     * delete a girl by id
     *
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }


    @PostMapping(value = "/girls/two")
    public void addTwoGirls() {
        girlService.AddTwoGirls();
    }

    @GetMapping(value = "/girls/age/validate/{id}")
    public void getAge(@PathVariable("id") Integer id) throws GirlException {
        girlService.getAge(id);
    }
}
