package com.user.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.services.RegistrationService;

@RestController
public class RegisterController {
	
	@Autowired 
	private RegistrationService service;
	
	
	@PostMapping("/register")
	public User register(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj=  service.getByEmailId(tempEmailId);
			
			if(userObj !=null) {
				throw new Exception("user with" +tempEmailId+"is already exit");
			}
			
			
		}
		User userobj = null;
		userobj= service.saveUser(user);
		return userobj;
		
		
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String password = user.getPassword();
		User userobj = null;
		if(tempEmailId!=null && password !=null) {
			
			userobj = service.getByEmailIdAndPassword(tempEmailId, password);
			
		}
		if(userobj == null) {
			throw new Exception("bad credential");
		}
		return userobj;
	}
	
}
