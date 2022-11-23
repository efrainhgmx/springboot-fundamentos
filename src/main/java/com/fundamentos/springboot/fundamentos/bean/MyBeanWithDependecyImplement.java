package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependecyImplement implements MyBeanWithDependecy{
    private MyOperation myOperation;

    public MyBeanWithDependecyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependecy() {
        myOperation.suma(2);
        System.out.println("Hola desde el Bean con dependencia");
    }
}
