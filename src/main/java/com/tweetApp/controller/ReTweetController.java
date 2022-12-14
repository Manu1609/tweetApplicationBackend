package com.tweetApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.entity.ReTweetpost;
import com.tweetApp.request.CreateReTweetRequest;
import com.tweetApp.service.RetweetService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1.0/tweets")
public class ReTweetController {

	@Autowired
	private RetweetService retweetService;
	
		@GetMapping("allRetweets/{tweetid}")
		public List<ReTweetpost> getAllReTweets(@PathVariable("tweetid") Integer tweetid) {
			log.info("Getting all Retweets");
			List<ReTweetpost> allReTweets = retweetService.getAllReTweetsByTweetId(tweetid);
			return allReTweets;
		}
	
	  @PostMapping("/{username}/addRetweet/{tweetid}")
	   	public ReTweetpost reTweetCreate(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid ,@RequestBody CreateReTweetRequest createReTweetRequest) {
		  log.info("Creating a Retweet");
		  ReTweetpost reTweetpost = retweetService.reTweetCreate(createReTweetRequest , username,tweetid);
	   		return new ReTweetpost(reTweetpost);
	   	}
	    
	    @PutMapping("/{username}/updateRetweet/{retweetid}")
	   	public ReTweetpost reTweetUpdate(@PathVariable("username") String username,@PathVariable("retweetid") Integer retweetid ,@RequestBody CreateReTweetRequest createReTweetRequest) {
	    	log.info("Updating a retweet");
	    	ReTweetpost reTweetpost = retweetService.reTweetUpdate(createReTweetRequest , retweetid);
	   		return new ReTweetpost(reTweetpost);
	   	}
	    
	    @DeleteMapping("/{username}/deleteRetweet/{retweetid}")
	   	public void deleteReTweet(@PathVariable("username") String username,@PathVariable("retweetid") Integer retweetid) {
	    	log.info("Deleting a Retweet");
;	    	retweetService.deleteTweet(retweetid);
	   	}
	    
}
