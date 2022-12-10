package com.tweetApp.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateReTweetRequest {

	private Integer retweetid;
	
	private String retweet;
	
	private LocalDateTime retweettime;
	
	private String username;
	
	private Integer tweetid;

}
