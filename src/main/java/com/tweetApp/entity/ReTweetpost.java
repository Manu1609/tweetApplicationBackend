package com.tweetApp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.tweetApp.request.CreateReTweetRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReTweetpost {
    
	@Id
    @GeneratedValue
    @Column( length = 45)
    private Integer retweetid;
    @Column( length = 144)
    private String retweet;
    @Column( length = 45)
    private LocalDateTime retweettime;  
    @Column( length = 45)
    private String username;
    @Column( length = 45)
    private Integer tweetid;
    
    public ReTweetpost(CreateReTweetRequest createReTweetRequest, String username, Integer tweetid) {
    	this.retweetid = createReTweetRequest.getRetweetid();
    	this.retweet = createReTweetRequest.getRetweet();
		this.username = username;
		this.retweettime = java.time.LocalDateTime.now();
		this.tweetid =  tweetid;
	}

	public ReTweetpost(ReTweetpost reTweetpost) {
		this.retweetid = reTweetpost.getRetweetid();
		this.retweet = reTweetpost.getRetweet();
		this.username = reTweetpost.getUsername();
		this.retweettime = java.time.LocalDateTime.now();
		this.tweetid =  reTweetpost.getTweetid();
	}
}
