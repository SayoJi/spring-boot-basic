package com.sayo.girl.repository;

import com.sayo.girl.domain.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shuangyao
 * 7:59 2018/1/17
 */
public interface ChildRepository extends JpaRepository<Child, Integer>{
    List<Child> findByHomeNo(Integer homeNO);
}
