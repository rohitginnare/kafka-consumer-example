package com.javatechie.kafka_consumer_example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.javatechie.kafka_consumer_example.dto.Customer;

@Service
public class KafkaMessageListener {

	Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

//	@KafkaListener(topics = "javatechie-demo1", groupId = "jt-group")
//	public void consume1(String message) {
//		log.info("Consumer1 consumed message {}", message);
//	}
//
//	@KafkaListener(topics = "javatechie-demo1", groupId = "jt-group")
//	public void consume2(String message) {
//		log.info("Consumer2 consumed message {}", message);
//	}
//
//	@KafkaListener(topics = "javatechie-demo1", groupId = "jt-group")
//	public void consume3(String message) {
//		log.info("Consumer3 consumed message {}", message);
//	}
//
//	@KafkaListener(topics = "javatechie-demo1", groupId = "jt-group")
//	public void consume4(String message) {
//		log.info("Consumer4 consumed message {}", message);
//	}

	@KafkaListener(topics = "javatechie-customer", groupId = "jt-group-new-customer")
	public void consume(Customer customer) {
		log.info("Consumed data from Customer Object...");
	}

}
