package com.sayo.girl.repository;

import com.sayo.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shuangyao
 * 17:30 2018/1/2
 */
public interface GirlRepository extends JpaRepository<Girl, Integer> {
    // get girls by age
    public List<Girl> findByAge(Integer age);
}
