package com.wwh.demo.java.serializable.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private Integer age;

    private final static long serialVersionUID = 1l;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: " + name + "; age: " + age;
    }
}
