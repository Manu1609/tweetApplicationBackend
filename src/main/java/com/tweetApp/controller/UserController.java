package com.tweetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.Kafka.Producer;
import com.tweetApp.entity.User;
import com.tweetApp.request.CreateUserRequest;
import com.tweetApp.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders={"Accept"})
@RequestMapping("/api/v1.0/tweets")
public class UserController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public Producer producer;

	
	
	@GetMapping(value = "/get")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers,HttpStatus.OK);
	}

	@PostMapping("register")
	public ResponseEntity<User> userCreate(@RequestBody CreateUserRequest createUserRequest) {
		User user = userService.createUser(createUserRequest);

		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	@GetMapping("login/{username}/{password}")
	public ResponseEntity<Boolean> userLogin(@PathVariable("username") String username,@PathVariable("password") String password) {
		
//		producer.sendMessageToTopic(username);
		Boolean user = userService.login(username,password);
		return new ResponseEntity<Boolean>(user,HttpStatus.OK);
	}
	
	@PostMapping("changePassword/{username}/{password}")
	public ResponseEntity<Boolean> changePassword(@PathVariable("username") String username,@PathVariable("password") String password) {
		Boolean user = userService.changePassword(username,password);
		return new ResponseEntity<Boolean>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePassword/{username}")
   	public Boolean forgotPassword(@PathVariable("username") String username) {
		 return userService.forgotPassword(username);
   	}
	
}
