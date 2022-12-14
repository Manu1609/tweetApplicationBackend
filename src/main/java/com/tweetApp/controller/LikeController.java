package com.tweetApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.entity.TweetLike;
import com.tweetApp.request.CreateLikeRequest;
import com.tweetApp.service.LikeTweetService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1.0/tweets")
public class LikeController {
     
	@Autowired
	private LikeTweetService likeTweetService;
	
	@PutMapping("/{username}/like/{tweetid}")
   	public TweetLike tweetLikeCreate(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid) {
		log.info("Creating Tweet Like column to datbase");
		TweetLike likeTweet = likeTweetService.tweetLikeCreate( tweetid,username);
   		return new TweetLike(likeTweet);
   	}
	
	@GetMapping("/{username}/getlike/{tweetid}")
   	public Boolean getTweetLike(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid) {
		log.info("Getting TweetLike value of Username and TweetId");
		Boolean likeTweet = likeTweetService.getTweetLike( tweetid,username);
   		return likeTweet;
   	}
	
	
	@PostMapping("/{username}/likeupdate/{tweetid}")
   	public TweetLike tweetLikeUpdate(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid ,@RequestBody CreateLikeRequest createLikeRequest) {
		log.info("Making Tweet Like Update");
		TweetLike likeTweet = likeTweetService.tweetLikeUpdate(createLikeRequest , tweetid,username);
   		return new TweetLike(likeTweet);
   	}
}
