package com.tweetApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweetApp.entity.TweetPost;
import com.tweetApp.entity.User;
import com.tweetApp.repository.TweetRepository;
import com.tweetApp.request.CreateTweetRequest;
import com.tweetApp.request.UpdateTweetRequest;

@Service
public class TweetServiceImpl implements TweetService {
	
	 @Autowired
	 private TweetRepository tweetRepository;

	public List<TweetPost> getAllTweets() {
		return tweetRepository.findAll();
	}
	
	@Override
	public List<TweetPost> getAllTweetsOfUsername(String username) {
		
		List<TweetPost> tweetPost =  tweetRepository.findByUsername(username);
		
		System.out.println(tweetPost);
		return tweetPost;
	}

	@Override
	public TweetPost tweetCreate(CreateTweetRequest createTweetRequest , String username) {
		TweetPost tweetPost = new TweetPost(createTweetRequest, username);
		tweetPost = tweetRepository.save(tweetPost);
		return tweetPost;
	}

	
	@Override
	public TweetPost tweetUpdate(UpdateTweetRequest updateTweetRequest, Integer tweetid) {
		TweetPost tweetPost = tweetRepository.findById(tweetid).get();
		if(updateTweetRequest.getTweet() != null && !updateTweetRequest.getTweet().isEmpty()) {
			tweetPost.setTweet(updateTweetRequest.getTweet());
		}
		
		tweetPost.setTweetDate(java.time.LocalDateTime.now());
		
		if(updateTweetRequest.getLikeCount() != null ) {
			tweetPost.setLikeCount(updateTweetRequest.getLikeCount());
		}
		if(updateTweetRequest.getUsername_fk() != null && !updateTweetRequest.getUsername_fk().isEmpty()) {
			tweetPost.setUsername(updateTweetRequest.getUsername_fk());
		}
		tweetPost = tweetRepository.save(tweetPost);
		return tweetPost;
	}

	@Override
	public void deleteTweet(int tweetid) {
		tweetRepository.deleteById(tweetid);
	}

	
}
