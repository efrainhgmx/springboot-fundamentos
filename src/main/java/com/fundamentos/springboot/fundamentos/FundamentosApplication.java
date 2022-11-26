package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependecy;
import com.fundamentos.springboot.fundamentos.bean.RestBean;
import com.fundamentos.springboot.fundamentos.component.ComponentDependecy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	private ComponentDependecy componentDependecy;
	private MyBean myBean;

	private MyBeanWithDependecy myBeanWithDependecy;

    private RestBean restBean;

	private MyBeanProperties myBeanProperties;
	@Autowired
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependecy componentDependecy,
                                  MyBean myBean,
                                  MyBeanWithDependecy myBeanWithDependecy,
                                  RestBean restBean,
								  MyBeanProperties myBeanProperties) {
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependecy = myBeanWithDependecy;
        this.restBean = restBean;
		this.myBeanProperties = myBeanProperties;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependecy.Saludar();
		myBean.print();
		myBeanWithDependecy.printWithDependecy();
		restBean.uppercase("hola por aca!!!");
		System.out.println(myBeanProperties.function());
	}
}
