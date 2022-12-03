package com.tweetApp.entity;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tweetApp.request.CreateTweetRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TweetPost {

	@Id
	@Column( length = 45)
    @GeneratedValue
    private Integer tweetid;
	@Column( length = 144)
	
	@NotNull
	@NotBlank
	@NotEmpty
    private String tweet;
	
	@Column( length = 45)
    private LocalDateTime tweetDate;
	@Column( length = 45)
    private Integer likeCount;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column( length = 45)
    private String username;
	
	
//    @OneToMany(targetEntity = ReTweetpost.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="tweetid_fk",referencedColumnName = "tweetid")
//    private List<ReTweetpost> ReTweetpost;
    
//    @OneToMany(targetEntity = TweetLike.class,cascade = CascadeType.ALL)
//    @JoinColumn(name ="tweetid_fk",referencedColumnName = "tweetid")
//    private List<TweetLike> TweetLike;
    
    public TweetPost(TweetPost tweetPost) {
    	this.tweetid = tweetPost.getTweetid();
    	this.tweet = tweetPost.getTweet();
    	this.tweetDate = tweetPost.getTweetDate();
    	this.likeCount = tweetPost.getLikeCount();
    	this.username = tweetPost.getUsername();
    	
		
	}

	public TweetPost(CreateTweetRequest createTweetRequest,String username) {
		this.tweetid = createTweetRequest.getTweetid();
    	this.tweet = createTweetRequest.getTweet();
    	this.tweetDate = java.time.LocalDateTime.now();
    	this.likeCount = createTweetRequest.getLikeCount();
    	this.username = username;	}


	public TweetPost(Optional<TweetPost> updateTweet) {
	
	}
    
}
