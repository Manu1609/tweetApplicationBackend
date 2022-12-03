package com.tweetApp.service;

import java.util.List;
import java.util.Optional;

import com.tweetApp.entity.User;
import com.tweetApp.request.CreateUserRequest;

public interface UserService {
	
	Optional<User> finduserbyId(int userid);

	List<User> getAllUsers();
	
	User createUser(CreateUserRequest createUserRequest);

	Boolean login(String username, String password);
}
