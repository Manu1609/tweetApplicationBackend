package com.tweetApp.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweetApp.entity.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,  Integer >{
	

	User findByUserName(String username);

	
	@Query("UPDATE User u SET password = :password WHERE u.userName = :userName")
	@Modifying
	void changePassword(@Param("userName") String userName, @Param("password") String password);

	@Query("DELETE User u  WHERE u.userName = :userName")
	@Modifying
	void deleteByUsername(String userName);
	

}
