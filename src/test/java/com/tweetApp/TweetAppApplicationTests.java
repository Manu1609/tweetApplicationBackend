package com.tweetApp;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.time.LocalDateTime;

import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tweetApp.entity.ReTweetpost;
import com.tweetApp.entity.TweetLike;
import com.tweetApp.entity.TweetPost;
import com.tweetApp.entity.User;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TweetAppApplication.class)
class TweetAppApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Test
//	void main() {
//		TweetAppApplication.main(new String[] {});
//	}

	@Test
	void testNoArgs() {
		assertThat(new User()).isNotNull();
		assertThat(new ReTweetpost()).isNotNull();
		assertThat(new TweetLike()).isNotNull();
		assertThat(new TweetPost()).isNotNull();
	}
	
	@Test
	void testAllArgs() throws ParseException {
		User user = new User(1,"Manoj@gmail.com","manoj","kumar" ,DateUtil.parse("2022-12-12"), "123456","8464052899");
		

	}
	
	@Test
	void testAllArgsTweet() throws ParseException {
		TweetPost tweetpost = new TweetPost(16,"Hii",LocalDateTime.now(),36, "manoj@gmail.com");
	}
	
	@Test
	void testAllArgsTweetLike() throws ParseException {
		TweetLike tweetLike = new TweetLike(16,true, "manoj@gmail.com",91);
	}
	
	
	
	@Test
	void testSetterMethod() throws ParseException {
		User user = new User();
		user.setContactNumber("8464052877");
		user.setFirstName("Manoj");
		user.setUserid(29000);
		user.setLastName("Kumar");
		user.setPassword("123456");
		user.setUserName("Manoj@gmail.com");
		user.setDob(DateUtil.parse("1998-09-16"));
		
		TweetPost tweetPost = new TweetPost();
		tweetPost.setTweetid(16);
		tweetPost.setTweet("Manoj");
		tweetPost.setTweetDate(LocalDateTime.now());
		tweetPost.setLikeCount(25);
		tweetPost.setUsername("Manoj@gmail.com");
		
		ReTweetpost reTweetPost = new ReTweetpost();
		reTweetPost.setTweetid(16);
		reTweetPost.setRetweet("Manoj");
		reTweetPost.setRetweettime(LocalDateTime.now());
		reTweetPost.setUsername("Manoj@gmail.com");
		
		TweetLike tweetLike = new TweetLike();
		tweetLike.setTweetid(16);
		tweetLike.setTweetBoolean(true);
		tweetLike.setTweetLikeId(15);
		tweetLike.setUsername("Manoj@gmail.com");

		
		assertThat(assertThat(user).isNotNull());
		assertThat(assertThat(tweetPost).isNotNull());
		assertThat(assertThat(reTweetPost).isNotNull());
		assertThat(assertThat(tweetLike).isNotNull());



	}
	
	
	
	@Test
	void testNotEqualAndHashCode() throws ParseException {
		User user1 = new User(1,"Manoj@gmail.com","manoj","kumar" ,DateUtil.parse("2022-12-12"), "123456","8464052899");

		User user2 = new User(2,"Manoj@gmail.com","manoj","kumar" ,DateUtil.parse("2022-12-12"), "123456","8464052899");

		assertThat(assertThat(user1).isNotEqualTo(user2));
		
		TweetPost tweetpost1 = new TweetPost(16,"Hii",LocalDateTime.now(),36, "manoj@gmail.com");

		TweetPost tweetpost2 = new TweetPost(18,"Hii",LocalDateTime.now(),36, "manoj@gmail.com");
		
		assertThat(assertThat(tweetpost1).isNotEqualTo(tweetpost2));
		
		TweetLike tweetLike1 = new TweetLike(16,true, "manoj@gmail.com",91);

		TweetLike tweetLike2 = new TweetLike(18,true, "manoj@gmail.com",91);

		assertThat(assertThat(tweetLike1).isNotEqualTo(tweetLike2));


	}
	
}
