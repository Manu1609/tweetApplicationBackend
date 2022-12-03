package com.tweetApp.service;

import java.util.List;
import java.util.Optional;

import com.tweetApp.entity.TweetPost;
import com.tweetApp.request.CreateTweetRequest;
import com.tweetApp.request.UpdateTweetRequest;

public interface TweetService {

	List<TweetPost> getAllTweets();

	TweetPost tweetCreate(CreateTweetRequest createTweetRequest, String username);

	TweetPost tweetUpdate(UpdateTweetRequest updateTweetRequest, Integer tweetid);

	void deleteTweet(int tweetid);

	List<TweetPost> getAllTweetsOfUsername(String username);
}