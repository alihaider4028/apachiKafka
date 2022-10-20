package com.ali.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	private KafkaProducer kafkaproducer;

	public MessageController(KafkaProducer kafkaproducer) {
		this.kafkaproducer = kafkaproducer;
	}
	@GetMapping("/publish/{message}")
	public ResponseEntity<String> publish(@PathVariable String message){
		kafkaproducer.sendmessage(message);
		return ResponseEntity.ok("message has been send");
		
		
		
	}
}
