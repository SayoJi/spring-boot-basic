package com.sayo.girl.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Shuangyao
 * 23:16 2018/1/15
 */

@Entity
public class Parent {

    @Id
    @Column(name = "HOME_NO")
    private Integer homeNo;
    private String name;
    private String job;
    private Integer income;

    @OneToMany()
    @JoinColumn(name = "HOME_NO",insertable=false, updatable=false)
    private List<Child> childList;

    public Parent() {
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public Integer getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(Integer homeNo) {
        this.homeNo = homeNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "homeNo=" + homeNo +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", income=" + income +
                '}';
    }
}
