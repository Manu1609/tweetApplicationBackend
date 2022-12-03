package com.tweetApp.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReTweetRequest {

	private Integer retweetid;
	
	private String retweet;
	
	private Date retweettime;
	
	private String username;
	
	private Integer tweetid;

}
