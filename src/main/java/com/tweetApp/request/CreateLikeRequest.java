package com.tweetApp.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLikeRequest {

	private Integer tweetLikeId;
	
	private boolean tweetBoolean;
	

}
