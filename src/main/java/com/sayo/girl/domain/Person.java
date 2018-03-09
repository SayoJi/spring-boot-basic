package com.sayo.girl.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * In order to test On class have Embedble id and link to another class with @ManyToOne
 */
@Entity
public class Person {
    @Column(name = "NAME")
    private String name;
    @EmbeddedId
    private PrimaryKey primaryKey;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(PrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public static class PrimaryKey {
        @Column(name = "ID1")
        private String id1;
        @Column(name = "ID2")
        private String id2;

        public String getId1() {
            return id1;
        }

        public void setId1(String id1) {
            this.id1 = id1;
        }

        public String getId2() {
            return id2;
        }

        public void setId2(String id2) {
            this.id2 = id2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PrimaryKey that = (PrimaryKey) o;
            return Objects.equals(id1, that.id1) &&
                    Objects.equals(id2, that.id2);
        }

        @Override
        public int hashCode() {

            return Objects.hash(id1, id2);
        }
    }

}
