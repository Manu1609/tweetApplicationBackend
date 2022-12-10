package com.tweetApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweetApp.entity.TweetPost;
import com.tweetApp.entity.User;
import com.tweetApp.request.CreateTweetRequest;
import com.tweetApp.request.CreateUserRequest;
import com.tweetApp.request.UpdateTweetRequest;
import com.tweetApp.service.LikeTweetService;
import com.tweetApp.service.TweetService;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class TweetController {
	
    @Autowired
    private TweetService tweetService;
    
   

    @GetMapping("all")
	public List<TweetPost> getAllTweets() {
		List<TweetPost> allTweets = tweetService.getAllTweets();
		return allTweets;
	}
    
    @GetMapping("/{username}")
	public List<TweetPost> getAllTweetsOfUsername(@PathVariable("username") String username ) {
		List<TweetPost> userTweets = tweetService.getAllTweetsOfUsername(username);
		return userTweets;
	}
    
    @GetMapping("/getTweet/{tweetid}")
	public TweetPost getTweetsOfTweetId(@PathVariable("tweetid") Integer tweetid ) {
		TweetPost tweet = tweetService.getTweetsOfTweetId(tweetid);
		return tweet;
    }
    
    @PostMapping("/{username}/add")
   	public TweetPost tweetCreate(@PathVariable("username") String username ,@RequestBody CreateTweetRequest createTweetRequest) {
   		TweetPost tweetPost = tweetService.tweetCreate(createTweetRequest , username);
   		
   		
   		return new TweetPost(tweetPost);
   	}
    
    @PutMapping("/{username}/update/{tweetid}")
   	public TweetPost tweetUpdate(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid ,@RequestBody UpdateTweetRequest updateTweetRequest) {
    	TweetPost updateTweet = tweetService.tweetUpdate(updateTweetRequest , tweetid);
    		System.out.println(updateTweet);
   		return new TweetPost(updateTweet);
   	}
    
    @DeleteMapping("/{username}/delete/{tweetid}")
   	public void deleteTweet(@PathVariable("username") String username,@PathVariable("tweetid") Integer tweetid) {
    	tweetService.deleteTweet(tweetid);
   	}
    
    @GetMapping("/likeCount/{tweetid}")
   	public TweetPost getLikeCount(@PathVariable("tweetid") Integer tweetid ) {
   		TweetPost likeCount = tweetService.getLikeCount(tweetid);
   		return likeCount;
   	}
}
