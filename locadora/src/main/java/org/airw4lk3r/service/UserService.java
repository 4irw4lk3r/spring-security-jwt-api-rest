package org.airw4lk3r.service;

import org.airw4lk3r.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

	User findUser(Long id);
	

}
