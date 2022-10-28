package com.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.RegRepo;

@Service

public class RegistrationService {
	
	@Autowired
	private RegRepo regrepo;
	
	public User saveUser(User user) {
		
		return regrepo.save(user);
		
	}
	
	public User getByEmailId(String email) {
		return regrepo.findByEmailId(email);
	}
	
	public User getByEmailIdAndPassword(String email,String password) {
		return regrepo.findByEmailIdAndPassword(email, password);
	}


}
