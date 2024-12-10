package com.chirohi.mongodemo.kafka.consumer.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyTestKafkaConsumerService {

	Logger log = LoggerFactory.getLogger(getClass());
	
	Properties consumerProperties = new Properties();
	
	
	//@KafkaListener(topics = "test", groupId = "topic-from-service")
	public List<String> consume() {
		
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString());
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProperties);
		//log.info("test consumer consumed message {} "+message);
		
		consumer.subscribe(Arrays.asList("test"));
		
		List<String> messageList = new ArrayList<>();
		
		ConsumerRecords<String, String> records = consumer.poll(Duration.ofSeconds(5));
		
		for (ConsumerRecord<String, String> consumerRecord : records) {
			
			log.info(consumerRecord.value());
			messageList.add(consumerRecord.value());
		}
		
		return messageList;
	}
}
