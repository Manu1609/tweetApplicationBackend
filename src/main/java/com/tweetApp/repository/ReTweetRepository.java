package com.tweetApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tweetApp.entity.ReTweetpost;
import com.tweetApp.entity.TweetPost;

@Repository
public interface ReTweetRepository extends JpaRepository<ReTweetpost,  Integer >{

	@Query("FROM ReTweetpost t where t.tweetid = :tweetid ORDER BY t.retweettime DESC")
	List<ReTweetpost> findByTweetid(Integer tweetid);
}
