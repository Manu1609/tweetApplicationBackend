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
	public TweetLike tweetLikeCreate(Integer tweetid,String username) {
		TweetLike tweetLike = new TweetLike( tweetid, username);
		tweetLike = likeTweetRepository.save(tweetLike);
		return tweetLike;
	}

	public TweetLike tweetLikeUpdate(CreateLikeRequest createLikeRequest, Integer tweetid, String username) {
		TweetLike tweetLike = likeTweetRepository.findByTweetidAndUsername(tweetid, username);
		if(tweetLike != null) {
		tweetLike.setTweetBoolean((createLikeRequest.isTweetBoolean()));
		tweetLike.setTweetid(tweetid);
		tweetLike.setUsername(username);
		tweetLike = likeTweetRepository.save(tweetLike);
		}
		else {
			TweetLike tweetcreate = new TweetLike( tweetid, username);
			tweetLike = likeTweetRepository.save(tweetcreate);
			TweetLike tweetLikes = likeTweetRepository.findByTweetidAndUsername(tweetid, username);
			tweetLikes.setTweetBoolean((createLikeRequest.isTweetBoolean()));
			tweetLikes.setTweetid(tweetid);
			tweetLikes.setUsername(username);
			tweetLike = likeTweetRepository.save(tweetLikes);
		}
		return tweetLike;
	}

	@Override
	public Boolean getTweetLike(Integer tweetid, String username) {
		TweetLike tweetLike =  likeTweetRepository.findByTweetidAndUsername(tweetid, username);
		
		return tweetLike.isTweetBoolean();
	}
}
