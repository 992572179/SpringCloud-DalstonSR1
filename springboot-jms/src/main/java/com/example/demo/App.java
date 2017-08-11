package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/20.
 */
@Component
public class App {

    private static final Logger log = LoggerFactory.getLogger(SpringbootJmsApplication.class);

    @Autowired
    private JavaMailSenderImpl senderImpl;


    @Scheduled(fixedRate = 5000)
    public void sendText() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(new String[] { "992572179@qq.com" });
        message.setFrom("tsunenorikawano@163.com");
        message.setSubject("hello jms!");
        message.setText("系统将每5秒发送一封邮件，现在时刻:" + dateFormat.format(new Date()));

        senderImpl.send(message);
        log.info("邮件已发送！");

    }
}
