package org.airw4lk3r.service.impl;

import org.airw4lk3r.model.User;
import org.airw4lk3r.repository.UserRepository;
import org.airw4lk3r.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findUser(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
}
