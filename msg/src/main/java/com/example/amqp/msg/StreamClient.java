package com.example.amqp.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    @Input("myMsg")
    SubscribableChannel input();

    @Output("myMsg")
    MessageChannel output();
}
