package com.chirohi.mongodemo.kafka.producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisherService {
	
	@Autowired
	KafkaTemplate<String, Object> template;
	
	public void sendMessageToKafkaTopic(String message) {
		
	CompletableFuture<SendResult<String, Object>> future =  template.send("topic-from-service", message);
	
	future.whenComplete((result,ex) -> {
		
		if(ex==null) {
			System.out.println("message sent-->"+result.getRecordMetadata().offset());
		}
		else {
			
			System.out.println("Unable to send message-->"+ex.getMessage());
			
		}
	});
		
	}

}
