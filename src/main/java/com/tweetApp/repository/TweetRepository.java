package com.tweetApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetApp.entity.TweetPost;

@Repository
public interface TweetRepository extends JpaRepository<TweetPost,  Integer >{

	List<TweetPost> findByUsername(String username);

	TweetPost findByTweetid(Integer tweetid);

	@Query("FROM TweetPost t ORDER BY t.tweetDate DESC")
	List<TweetPost> findAllByDate();

}
