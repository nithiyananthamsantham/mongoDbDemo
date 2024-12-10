package com.chirohi.mongodemo.kafka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chirohi.mongodemo.kafka.consumer.service.MyTestKafkaConsumerService;

@RestController
@RequestMapping("/kafka/consumer")
public class KafkaConsumerServiceController {
	
	@Autowired
	private MyTestKafkaConsumerService consumerService;
	
	@GetMapping("/consumeMessage")
	public ResponseEntity<Object> consumeKafkaMessage(){
		
		
		return ResponseEntity.ok("Successfully received message from kafka!!!"+consumerService.consume());
	}
	

}
