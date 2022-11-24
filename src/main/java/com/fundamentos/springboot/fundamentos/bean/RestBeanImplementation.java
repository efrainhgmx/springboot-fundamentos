package com.fundamentos.springboot.fundamentos.bean;

public class RestBeanImplementation implements RestBean{
    @Override
    public String uppercase(String word) {
        System.out.println(word.toUpperCase());
        return word.toUpperCase();
    }
}
