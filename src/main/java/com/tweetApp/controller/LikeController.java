package com.tweetApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.entity.TweetLike;
import com.tweetApp.request.CreateLikeRequest;
import com.tweetApp.service.LikeTweetService;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class LikeController {
     
	@Autowired
	private LikeTweetService likeTweetService;
	
	@PutMapping("/{username}/like/{tweetid}")
   	public TweetLike tweetLikeCreate(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid ,@RequestBody CreateLikeRequest createLikeRequest) {
		TweetLike likeTweet = likeTweetService.tweetLikeCreate(createLikeRequest , tweetid,username);
    		System.out.println(likeTweet);
   		return new TweetLike(likeTweet);
   	}
	
	@PostMapping("/{username}/likeupdate/{tweetid}")
   	public TweetLike tweetLikeUpdate(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid ,@RequestBody CreateLikeRequest createLikeRequest) {
		TweetLike likeTweet = likeTweetService.tweetLikeUpdate(createLikeRequest , tweetid,username);
    		System.out.println(likeTweet);
   		return new TweetLike(likeTweet);
   	}
}
