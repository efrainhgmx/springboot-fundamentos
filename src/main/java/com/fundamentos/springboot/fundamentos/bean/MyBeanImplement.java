package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanImplement implements MyBean{
    @Override
    public void Print() {
        System.out.println("Hola desde el Bean");
    }
}
