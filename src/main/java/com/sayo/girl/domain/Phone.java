package com.sayo.girl.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Phone {
    private String id;
    @ManyToOne()
    private Person person;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
