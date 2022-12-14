package com.tweetApp.entityTests;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.time.LocalDateTime;

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
@ContextConfiguration(classes = ReTweetpost.class)
public class ReTweetTestEntity {

	@Test
	void contextLoads() {
	}
	
	
	@Test
	void testNoArgs() {
		assertThat(new User()).isNotNull();
		assertThat(new ReTweetpost()).isNotNull();
		assertThat(new TweetLike()).isNotNull();
		assertThat(new TweetPost()).isNotNull();
	}
	
	@Test
	void testAllArgs() throws ParseException {
		ReTweetpost reTweetpost = new ReTweetpost(16,"Hii",LocalDateTime.now(), "manoj@gmail.com",25);
	}
	
	@Test
	void testNotEqualAndHashCode() throws ParseException {
		ReTweetpost reTweetpost1 = new ReTweetpost(17,"Hii",LocalDateTime.now(), "manoj@gmail.com",25);

		ReTweetpost reTweetpost2 = new ReTweetpost(16,"Hii",LocalDateTime.now(), "manoj@gmail.com",25);

		assertThat(assertThat(reTweetpost1).isNotEqualTo(reTweetpost2));
	}
}
