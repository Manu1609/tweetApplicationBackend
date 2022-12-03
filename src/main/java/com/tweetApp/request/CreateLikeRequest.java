package com.tweetApp.request;

import lombok.Data;

@Data
public class CreateLikeRequest {

	private Integer tweetLikeId;
	
	private boolean tweetBoolean;
	
	private String username_fk;
	
	private Integer tweetid_fk;
	
	

}
