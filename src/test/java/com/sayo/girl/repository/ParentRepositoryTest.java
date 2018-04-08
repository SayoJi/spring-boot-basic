package com.sayo.girl.repository;

import com.sayo.girl.domain.Child;
import com.sayo.girl.domain.Parent;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuangyao
 * 22:49 2018/3/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParentRepositoryTest {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private ChildRepository childRepository;

    @Test
    public void testFindByChildName(){
//        Child sayo = new Child();
//        sayo.setName("sayo");
//        this.childRepository.save(sayo);
//
//        Child ly = new Child();
//        ly.setName("Ly");
//        this.childRepository.save(ly);

        List<Child> children = new ArrayList<>();
        Child child1 = this.childRepository.findOne(4);
        Child child2 = this.childRepository.findOne(5);

        children.add(child1);
        children.add(child2);

        Parent parent1 = new Parent();
        parent1.setHomeNo(22);
        parent1.setName("XunMao");
        parent1.setChildList(children);

        this.parentRepository.save(parent1);

        List<Parent> resultParent = this.parentRepository.findByChildList_Name("sayo");
        Parent parent = this.parentRepository.findOne(22);

        Assert.assertEquals(resultParent.size(),1);

    }


}
