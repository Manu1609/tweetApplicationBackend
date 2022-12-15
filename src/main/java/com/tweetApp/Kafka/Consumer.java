package com.tweetApp.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

	@KafkaListener(topics = "bridgeTopic", groupId = "bridge-group")
	public void listenToBridgeTopicKafkaTopic(String messageReceived) {
		System.out.println("UserName received is " + messageReceived);
	}
}
