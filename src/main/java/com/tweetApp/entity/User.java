package com.tweetApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tweetApp.request.CreateUserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "userid",length = 45)
	private Integer userid;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "user_name",nullable = false,unique = true,length = 45)
	private String userName;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "first_name",nullable = false,length = 45)
	private String firstName;
	
	@Column(name = "last_name",length = 45)
	private String lastName;
	
//	@NotNull
//	@NotBlank
//	@NotEmpty
//	@Email
//	@Column(name = "email",nullable = false,unique = true,length = 45)
//	private String email;
	
	@Column(name = "dob",length = 45)
	private Date dob;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column(name = "password",nullable = false,length = 45)
	private String password;
	
	@Column(name = "contact_number",length = 45)
	private String contactNumber;
	
//	@OneToMany(targetEntity = TweetPost.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "username_fk", referencedColumnName = "user_name")
//	private List<TweetPost> tweetpost;
	
//	@OneToMany(targetEntity = TweetLike.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "username_fk", referencedColumnName = "user_name")
//	private List<TweetLike> tweetList;
	

	
	public User(CreateUserRequest createUserRequest) {
		this.userid = createUserRequest.getUserid();
		this.userName = createUserRequest.getUserName();
		this.firstName = createUserRequest.getFirstName();
		this.lastName = createUserRequest.getLastName();
		//this.email = createUserRequest.getEmail();
		this.dob = createUserRequest.getDob();
		this.password = createUserRequest.getPassword();
		this.contactNumber = createUserRequest.getContactNumber();
	}



	public User(User user) {
		this.userid = user.getUserid();
		this.userName =user.getUserName();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		//this.email = user.getEmail();
		this.dob = user.getDob();
		this.password = user.getPassword();
		this.contactNumber = user.getContactNumber();
	}

	}
