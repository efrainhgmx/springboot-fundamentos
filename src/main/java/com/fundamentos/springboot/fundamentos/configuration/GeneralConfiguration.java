package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.MyBeanProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String lastName;

    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanProperties function() {
        return new MyBeanPropertiesImplement(name, lastName);
    }
}
