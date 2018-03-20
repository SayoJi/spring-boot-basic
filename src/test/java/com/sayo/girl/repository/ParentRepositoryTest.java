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

    @Test
    public void testFindByChildName(){
        Child sayo = new Child();
        sayo.setName("sayo");

        Child ly = new Child();
        ly.setName("Ly");

        List<Child> children = new ArrayList<>();
        children.add(sayo);
        children.add(ly);

        Parent parent1 = new Parent();
        parent1.setHomeNo(22);
        parent1.setName("XunMao");
        parent1.setChildList(children);

        this.parentRepository.save(parent1);

        List<Parent> resultParent = this.parentRepository.findByChildList_Name("sayo");

        Assert.assertEquals(resultParent.size(),1);

    }


}
