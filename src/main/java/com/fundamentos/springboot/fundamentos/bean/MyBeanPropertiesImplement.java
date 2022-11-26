package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanPropertiesImplement implements MyBeanProperties{
    private String name;
    private String lastName;

    public MyBeanPropertiesImplement(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String function() {
        return name + " " + lastName;
    }
}
