package org.airw4lk3r.controller;

import java.util.List;

import org.airw4lk3r.model.User;
import org.airw4lk3r.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public List<User> findAll(){
		return (List<User>) this.userRepository.findAll();
	}
	
	public User findUser(@PathVariable(value="id") Long id) {
		return this.userRepository.findById(id).orElse(null);
	}
}
