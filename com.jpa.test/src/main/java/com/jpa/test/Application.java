package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class); // ?? how come getting a bean of
																				// interface

		// create a user object to be stored in db
		User user = new User();
		user.setName("Rahul Kumar");
		user.setCity("Patna");
		user.setStatus("Not feeling well due to fever");

		User user1 = userRepository.save(user); // data saved in database successfully
		System.out.println(user1);
	}

}
