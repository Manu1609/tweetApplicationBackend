package com.tweetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp.entity.User;
import com.tweetApp.repository.UserRepository;
import com.tweetApp.request.CreateUserRequest;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> finduserbyId(int userid) {
		return userRepository.findById(userid);
	}

	public User createUser(CreateUserRequest createUserRequest) {
		User user = new User(createUserRequest);
		user = userRepository.save(user);
		return user;
	}

	@Override
	public Boolean login(String username, String password) {
		User user = userRepository.findByUserName(username);
		Boolean login = false;
		if (user != null) {
			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				login = true;
			}
		}
		return login;
	}

	
	public Boolean changePassword(String userName, String password) {
				userRepository.changePassword(userName,password);
		return true;
	}

	@Override
	public Boolean forgotPassword(String username) {
		
		User user = userRepository.findByUserName(username);
		System.out.println(user);
		if(user != null) {
			userRepository.deleteByUsername(username);
			return true;
		}
		else {
			return false;
		}
	}

}
