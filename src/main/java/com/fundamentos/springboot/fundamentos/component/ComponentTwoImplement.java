package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependecy{
    @Override
    public void Saludar() {
        System.out.println("Hola desde el componente dos");
    }
}
