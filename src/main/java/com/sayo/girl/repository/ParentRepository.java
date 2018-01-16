package com.sayo.girl.repository;

import com.sayo.girl.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Shuangyao
 * 8:01 2018/1/16
 */
public interface ParentRepository extends JpaRepository<Parent, Integer> {

    public List<Parent> findByHomeNo(Integer homeNo);
}
