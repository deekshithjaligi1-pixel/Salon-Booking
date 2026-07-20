package com.SaloonBookingSystem.service.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.SaloonBookingSystem.exception.UserException;
import com.SaloonBookingSystem.model.User;
import com.SaloonBookingSystem.repository.UserRepository;
import com.SaloonBookingSystem.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	private final UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		return userRepository.save(user); // returns Created user
	}
	
	@Override
	public User getUserById(Long id) throws UserException {
		Optional<User> otp = userRepository.findById(id);
		if (otp.isPresent()) {
			return otp.get();
		}
		throw new UserException("user not found");
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public void deleteUser(Long id) throws UserException {
		Optional<User> otp = userRepository.findById(id);
		if(otp.isEmpty()) {
			throw new UserException("user not exist with id "+id);
	}
		
		userRepository.deleteById(otp.get().getId());
		
	}
	
	@Override
	public User updateUser(Long id, User user) throws UserException {
		Optional<User> otp = userRepository.findById(id);
		if(otp.isEmpty()) {
			throw new UserException("user not found with id"+id);
		}
		User existingUser = otp.get();
		existingUser.setFullName(user.getFullName());
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		existingUser.setId(user.getId());
		existingUser.setRole(user.getRole());
		existingUser.setPassword(user.getPassword());
		
		
		return userRepository.save(existingUser);
	}



	
	

}
