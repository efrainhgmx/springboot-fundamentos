package com.fundamentos.springboot.fundamentos.bean;

public class RestBeanImplementation implements RestBean{
    @Override
    public String uppercase(String word) {
        return word.toUpperCase();
    }
}
