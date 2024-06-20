package com.javatechie.kafka_consumer_example.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

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

//	@KafkaListener(topics = "javatechie-customer-1", groupId = "jt-group-new-customer")
//	public void consume(com.kafka_producer_example.dto.Customer customer) {
//		log.info("Consumed data from Customer Object...: " + customer.toString());
//	}

	// consuming message on single partition of a topic
	@RetryableTopic(attempts = "3") //
	@KafkaListener(topics = "retry-topic", groupId = "retry-group", topicPartitions = {
			@TopicPartition(topic = "single-partition-message-send", partitions = "3") })
	public void consumeOnSinglePartition(String message) {
		String temp = "test";
		try {
			if (temp.equalsIgnoreCase("test")) {
				throw new RuntimeException("Message can not be consumed");
			} else {
				log.info("Message Consumed successfully..{}", message);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@DltHandler
	public void listenDLT(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.OFFSET) String offset) {
		log.info("DLT received : {} from {}, offset {}", message, topic, offset);
	}

}
