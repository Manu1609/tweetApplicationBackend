package com.tweetApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.tweetApp.request.CreateLikeRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"tweetid", "username"})}) 
public class TweetLike {

	@Id
	@Column( length = 45)
	@GeneratedValue
	private Integer tweetLikeId;
	@Column( length = 45)
	private boolean tweetBoolean;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column( length = 45)
	private String username;
	
	@NotNull
	@NotBlank
	@NotEmpty
	@Column( length = 45)
	private Integer tweetid;
	
	public TweetLike(CreateLikeRequest createLikeRequest, Integer tweetid, String username) {
		this.tweetBoolean = createLikeRequest.isTweetBoolean();
		this.tweetLikeId = createLikeRequest.getTweetLikeId();
		this.username = username;
		this.tweetid = tweetid;
	}

	public TweetLike(TweetLike likeTweet) {
		this.tweetBoolean = likeTweet.isTweetBoolean();
		this.tweetLikeId = likeTweet.getTweetLikeId()
;		this.username = likeTweet.getUsername();
		this.tweetid = likeTweet.getTweetid();
	}
}
