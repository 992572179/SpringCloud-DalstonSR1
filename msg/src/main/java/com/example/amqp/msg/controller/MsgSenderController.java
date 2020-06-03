package com.example.amqp.msg.controller;

import com.example.amqp.msg.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MsgSenderController {

    private StreamClient streamClient;

    @Autowired
    public void setStreamClient(StreamClient streamClient) {
        this.streamClient = streamClient;
    }


    @GetMapping("/send")
    public String sendMsg(){
        streamClient.output().send(MessageBuilder.withPayload("hello from stream, now :" + new Date()).build());
        return "success";
    }
}
