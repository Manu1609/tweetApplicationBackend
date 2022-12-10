package com.tweetApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp.entity.ReTweetpost;
import com.tweetApp.repository.ReTweetRepository;
import com.tweetApp.request.CreateReTweetRequest;

@Service
public class RetweetServiceImpl implements RetweetService {
	
	@Autowired
	private ReTweetRepository reTweetRepository;

	@Override
	public ReTweetpost reTweetCreate(CreateReTweetRequest createReTweetRequest, String username, Integer tweetid) {
		ReTweetpost reTweetpost = new ReTweetpost(createReTweetRequest, username,tweetid);
		reTweetpost = reTweetRepository.save(reTweetpost);
		return reTweetpost;
	}

	@Override
	public ReTweetpost reTweetUpdate(CreateReTweetRequest createReTweetRequest, Integer retweetid) {
		ReTweetpost reTweetPost = reTweetRepository.findById(retweetid).get();
		if(createReTweetRequest.getRetweet() != null && !createReTweetRequest.getRetweet().isEmpty()) {
			reTweetPost.setRetweet(createReTweetRequest.getRetweet());
		}
		
		reTweetPost.setRetweettime(java.time.LocalDateTime.now());

		if(createReTweetRequest.getUsername() != null && !createReTweetRequest.getUsername().isEmpty()) {
			reTweetPost.setUsername(createReTweetRequest.getUsername());
		}
		reTweetPost = reTweetRepository.save(reTweetPost);
		return 	reTweetPost;
	}
	
	@Override
	public void deleteTweet(int retweetid) {
		reTweetRepository.deleteById(retweetid);
	}

	@Override
	public List<ReTweetpost> getAllReTweetsByTweetId(int tweetid) {
		return reTweetRepository.findByTweetid(tweetid);
	}

}
