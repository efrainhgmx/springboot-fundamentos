package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependecy;
import com.fundamentos.springboot.fundamentos.bean.RestBean;
import com.fundamentos.springboot.fundamentos.component.ComponentDependecy;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	private ComponentDependecy componentDependecy;
	private MyBean myBean;

	private MyBeanWithDependecy myBeanWithDependecy;

    private RestBean restBean;

	private MyBeanProperties myBeanProperties;

	private UserPojo userPojo;

	private UserRepository userRepository;
	@Autowired
	public FundamentosApplication(@Qualifier("componentTwoImplement") ComponentDependecy componentDependecy,
                                  MyBean myBean,
                                  MyBeanWithDependecy myBeanWithDependecy,
                                  RestBean restBean,
								  MyBeanProperties myBeanProperties,
								  UserPojo userPojo,
								  UserRepository userRepository) {
		this.componentDependecy = componentDependecy;
		this.myBean = myBean;
		this.myBeanWithDependecy = myBeanWithDependecy;
        this.restBean = restBean;
		this.myBeanProperties = myBeanProperties;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//ejemplos();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser() {
		LOGGER.info("User finded user the method is " +  userRepository.findByUserEmail("carla@domain.com")
				.orElseThrow(() -> new RuntimeException("We can't find a user with this email")));

		userRepository.findAndSort("Mar", Sort.by("id").descending())
				.forEach( user -> LOGGER.info("User by sort method: " + user.getName()));

		userRepository.findByName("Carla").forEach(user -> System.out.println(user.getName() + " " + user.getId()));

		LOGGER.info(userRepository.findByUserEmail("carla@domain.com").orElseThrow(() -> new RuntimeException("El usuario no existe")));
	}

	private void saveUsersInDataBase() {
		User mario = new User("Mario", "mario@domain.com", LocalDate.of(2022,11,24).atStartOfDay());
		User inna = new User("Inna", "inna@domain.com", LocalDate.of(2022,10,4).atStartOfDay());
		User carla = new User("Carla", "carla@domain.com", LocalDate.of(2022,9,17).atStartOfDay());

		List<User> users = Arrays.asList(mario, inna, carla);

		users.forEach(userRepository::save);

	}
	private void ejemplos() {
		componentDependecy.Saludar();
		myBean.print();
		myBeanWithDependecy.printWithDependecy();
		restBean.uppercase("hola por aca!!!");
		System.out.println(myBeanProperties.function());
		System.out.println(userPojo.getEmail());
		LOGGER.error("Esto es un error");
	}
}
