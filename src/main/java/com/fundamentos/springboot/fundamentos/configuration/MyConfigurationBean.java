package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation() {
        return new MyBean2Implement();
    };

    @Bean
    public MyOperation myOperation() {
        return new MyOperationImplement();
    }

    @Bean
    public RestBean restBean() {
       return new RestBeanImplementation();
    }

    @Bean
    public MyBeanWithDependecy myBeanOperation(MyOperation myOperation) {
        return new MyBeanWithDependecyImplement(myOperation);
    }

}
