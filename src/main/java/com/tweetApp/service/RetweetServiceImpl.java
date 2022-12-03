package com.tweetApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp.entity.ReTweetpost;
import com.tweetApp.entity.TweetPost;
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
//		if(updateTweetRequest.getTweetDate() != null && !((List<TweetPost>) updateTweetRequest.getTweetDate()).isEmpty()) {
//			tweetPost.setTweetDate(updateTweetRequest.getTweetDate());
//		}
//		if(updateTweetRequest.getLikeCount() != null && !updateTweetRequest.getLikeCount().isEmpty()) {
//			tweetPost.setLikeCount(updateTweetRequest.getLikeCount());
//		}
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

}
