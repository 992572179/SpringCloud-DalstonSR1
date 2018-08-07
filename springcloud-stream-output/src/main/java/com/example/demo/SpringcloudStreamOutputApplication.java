package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableBinding(Source.class)
@SpringBootApplication
public class SpringcloudStreamOutputApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudStreamOutputApplication.class, args);
	}

	@InboundChannelAdapter(value = Source.OUTPUT)
	public String timerMessageSource() {
		String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		log.info("publish message :" + format);
		return format;
	}
}
