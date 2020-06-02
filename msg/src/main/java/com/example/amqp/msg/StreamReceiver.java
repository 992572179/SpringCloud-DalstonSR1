package com.example.amqp.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Slf4j
@EnableBinding(StreamClient.class)
@Component
public class StreamReceiver {

    @StreamListener("myMsg")
    public void handMsg(Object msg){
        log.info("handle msg: {}",msg);
    }


}
