package com.SaloonBookingSystem.service;

import java.util.List;

import com.SaloonBookingSystem.exception.UserException;
import com.SaloonBookingSystem.model.User;


public interface UserService {
	User createUser(User user);
	User getUserById(Long id) throws UserException;
	List<User> getAllUsers();
	void deleteUser(Long id) throws UserException;
	User updateUser(Long id,User user) throws UserException;
	
	
	}
