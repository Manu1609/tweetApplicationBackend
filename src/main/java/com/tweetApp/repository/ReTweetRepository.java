package com.tweetApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweetApp.entity.ReTweetpost;

@Repository
public interface ReTweetRepository extends JpaRepository<ReTweetpost,  Integer >{

}
