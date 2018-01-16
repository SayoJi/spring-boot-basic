package com.sayo.girl.testFunction;

import java.util.function.Function;

/**
 * this is for practice JAVA 1.8 new interface: Function
 * 21:00 2018/1/14
 */
public class FunctionDemo {

    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function){

        int newValue = function.apply(valueToBeOperated);

        /*
         * Do some operations using the new value.
         */

        System.out.println(newValue);

    }

    public static void main(String[] args) {

        int incr = 20;
        int myNumber = 10;

        //val-> val + incr
        //相当于定义了一个方法：
        //        int function(int val) {
        //            return val+incr;
        //        }
        modifyTheValue(myNumber, val-> val + incr);

        myNumber = 15;  modifyTheValue(myNumber, val-> val * 10);

        modifyTheValue(myNumber, val-> val - 100);

        modifyTheValue(myNumber, val-> "somestring".length() + val - 100);

        //insert into child(child_no, name, age, education, home_no) values(1,'Sayo', 18, 'university', 1);
        //insert into parent(home_no, name, job, income) values(1,'Six', 'doctor', 4000);


    }
}
