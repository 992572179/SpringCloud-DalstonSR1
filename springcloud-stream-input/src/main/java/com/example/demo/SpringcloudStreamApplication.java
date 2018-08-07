package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(Sink.class)
@SpringBootApplication
public class SpringcloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudStreamApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void sinkMessage(Object message) {
		log.info("-->接收到消息：\t" + message);
	}
}
