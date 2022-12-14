package com.tweetApp.service;

import com.tweetApp.entity.TweetLike;
import com.tweetApp.request.CreateLikeRequest;

public interface LikeTweetService {

	TweetLike tweetLikeCreate(Integer tweetid, String username);

	TweetLike tweetLikeUpdate(CreateLikeRequest createLikeRequest, Integer tweetid, String username);

	Boolean getTweetLike(Integer tweetid, String username);

}
