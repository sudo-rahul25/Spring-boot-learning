package com.jpa.test;

import java.util.List;

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

//		// create a user object to be stored in db
//		User user = new User();
//		user.setName("Sanjeet raj");
//		user.setCity("buxar");
//		user.setStatus("Not feeling well due to fever");
//		User user2 = new User();
//		user2.setName("Rahul Kumar");
//		user2.setCity("DElhi");
//		user2.setStatus("Not feeling well due to tension");
//		User user3 = new User();
//		user3.setName("Vatsaa kumar");
//		user3.setCity("Kolkata");
//		user3.setStatus("Not feeling well due to sickness");

//		User user4 = userRepository.save(user); // data saved in database successfully
//		System.out.println(user4);
		// userRepository.deleteAll();
//		User user5 = userRepository.save(user2); // data saved in database successfully
//		System.out.println(user5);
//		User user6 = userRepository.save(user3); // data saved in database successfully
//		System.out.println(user6);
//
//		List<User> users = userRepository.findByName("Vatsaa Kumar");
//		// user2.forEach(e -> System.out.println(e));
//
//		for (User user : users) {
//			System.out.println(user);
//		}

		// List<User> users1 = userRepository.findByNameOrCity("rahul", "Delhi"); //
		// lowercase/uppercase se farak
		// nhi pdta
//		List<User> users1 = userRepository.findByNameAndCity("rahul", "Delhi"); // lowercase/uppercase se farak
//		// nhi pdta

		// user2.forEach(e -> System.out.println(e));
//
//		for (User user : users1) {
//			System.out.println(user);
//		}
//		-----------------------------------------------------------------------------------------------
//		List<User> users2 = userRepository.findByNameStartingWith("ra");
//		for (User user : users2) {
//			System.out.println(user);
//		}
		// userRepository.deleteAll();

//		List<User> users2 = userRepository.findByNameEndingWith("ar");
//		for (User user : users2) {
//			System.out.println(user);
//		}
//
		List<User> users2 = userRepository.findByNameContaining("hu"); // name me kahi bhi a aaya hoga toh output"

		for (User user : users2) {
			System.out.println(user);
		}
		System.out.println("--------------------------------------------------------------------------------");
		List<User> users3 = userRepository.findByNameLike("%hu%"); // name me kahi bhi "hu" aaya hoga toh output
		// same functionality as containing but isme %hu% dena hoga
		for (User user : users3) {
			System.out.println(user);
		}
	}

}
