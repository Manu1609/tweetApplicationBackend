package com.tweetApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp.entity.TweetLike;
import com.tweetApp.repository.LikeTweetRepository;
import com.tweetApp.request.CreateLikeRequest;

@Service
public class LikeTweetServiceImpl implements LikeTweetService {

	@Autowired
	private LikeTweetRepository likeTweetRepository;

	@Override
	public TweetLike tweetLikeCreate(CreateLikeRequest createLikeRequest, Integer tweetid,String username) {
		TweetLike tweetLike = new TweetLike(createLikeRequest, tweetid, username);
		tweetLike = likeTweetRepository.save(tweetLike);
		return tweetLike;
	}

	public TweetLike tweetLikeUpdate(CreateLikeRequest createLikeRequest, Integer tweetid, String username) {
		TweetLike tweetLike = likeTweetRepository.findByTweetidAndUsername(tweetid, username);
		if(createLikeRequest.isTweetBoolean() ? true : false) {
			tweetLike.setTweetBoolean((createLikeRequest.isTweetBoolean()));
		}
		tweetLike = likeTweetRepository.save(tweetLike);
		System.out.println(tweetLike);
		return tweetLike;
	}
}
