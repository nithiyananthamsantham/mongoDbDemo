package com.chirohi.mongodemo.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chirohi.mongodemo.kafka.producer.service.KafkaMessagePublisherService;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

	@Autowired
	private KafkaMessagePublisherService kafkaMsgService;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> sendMessageToKafkaTopic(@PathVariable String message){
		
		try {
			kafkaMsgService.sendMessageToKafkaTopic(message);
			return ResponseEntity.ok("Successfully sent!!!");
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
