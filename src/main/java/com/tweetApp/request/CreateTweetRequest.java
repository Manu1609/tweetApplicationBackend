package com.tweetApp.request;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTweetRequest {

	private Integer tweetid;
	
	private String tweet;
		
	private LocalDateTime tweetDate; 
	
	private Integer likeCount;
	
	private String username_fk;

}
