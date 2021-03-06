package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> findByName(String name); // first name, last name, midname kch v dedo

	public List<User> findByNameOrCity(String name, String city); // name ya city se matching sb dedega

	public List<User> findByNameAndCity(String name, String city); // name and city both should matching enteries dega

	public List<User> findByNameStartingWith(String prefix); // name ke starting ka kch words se matching

	public List<User> findByNameEndingWith(String prefix); // name ke ending ka kch words se matching

	public List<User> findByNameContaining(String prefix); // kahi bhi naam me ye aayega toh matching like %like%

	public List<User> findByNameLike(String pattern);

}
