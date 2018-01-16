package com.sayo.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Shuangyao
 * 23:03 2018/1/15
 */

@Entity
public class Child {


    @Id
    @GeneratedValue
    private Integer childNo;
    private String name;
    private Integer age;
    private String education;
    private Integer homeNo;

    public Child() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getChildNo() {
        return childNo;
    }

    public void setChildNo(Integer childNo) {
        this.childNo = childNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(Integer homeNo) {
        this.homeNo = homeNo;
    }

    @Override
    public String toString() {
        return "Child{" +
                "childNo=" + childNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", homeNo=" + homeNo +
                '}';
    }
}
