package com.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.User;

public interface RegRepo extends JpaRepository<User, Integer> {
	
	public User findByEmailId(String email);
	
	public User findByEmailIdAndPassword(String email,String password);
}
