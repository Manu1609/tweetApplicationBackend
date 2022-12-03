package com.tweetApp.service;

import com.tweetApp.entity.ReTweetpost;
import com.tweetApp.entity.TweetPost;
import com.tweetApp.request.CreateReTweetRequest;

public interface RetweetService {

	ReTweetpost reTweetCreate(CreateReTweetRequest createReTweetRequest, String username, Integer tweetid);

	ReTweetpost reTweetUpdate(CreateReTweetRequest createReTweetRequest, Integer retweetid);

	void deleteTweet(int retweetid);

}
