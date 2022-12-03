package com.tweetApp.request;

import java.util.Date;

import lombok.Data;

@Data
public class CreateUserRequest {
	
	private Integer userid;
	
	private String userName;

	private String firstName;
	
	private String lastName;
	
	private String email;
		
	private Date dob;
	
	private String password;
	
	private String contactNumber;

}
