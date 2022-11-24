package com.fundamentos.springboot.fundamentos.bean;

public class RestBeanImplementation implements RestBean{
    @Override
    public void uppercase(String word) {
        System.out.println(word.toUpperCase());
    }
}
