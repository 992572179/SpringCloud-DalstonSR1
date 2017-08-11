package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss:SSS");
	@Scheduled(fixedRate = 1)
	public void reportCurrentTime() {
		LOGGER.info("现在时刻:" + DATE_FORMAT.format(new Date()));
	}

}
