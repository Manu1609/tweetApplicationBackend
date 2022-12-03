package com.tweetApp.entity;

import java.util.Date;

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
    @Column( length = 45)
    @GeneratedValue
    private Integer retweetid;
    @Column( length = 144)
    private String retweet;
    @Column( length = 45)
    private Date retweettime;  
    @Column( length = 45)
    private String username;
    @Column( length = 45)
    private Integer tweetid;
    
    public ReTweetpost(CreateReTweetRequest createReTweetRequest, String username, Integer tweetid) {
		this.retweet = createReTweetRequest.getRetweet();
		this.username = username;
		this.retweettime = createReTweetRequest.getRetweettime();
		this.tweetid =  tweetid;
	}

	public ReTweetpost(ReTweetpost reTweetpost) {
		this.retweet = reTweetpost.getRetweet();
		this.username = reTweetpost.getUsername();
		this.retweettime = reTweetpost.getRetweettime();
		this.tweetid =  reTweetpost.getTweetid();
	}
}
