package com.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User getUser(String username, String password) {
		User u = userRepository.getuser(username, password);		
		return u;
	}
}
