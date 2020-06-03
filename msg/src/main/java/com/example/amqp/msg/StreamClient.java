package com.example.amqp.msg;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 使用SpringCloudStream，屏蔽掉底层数据库中间件的具体操作，如QueueName、Exchange、RoutingKey等等
 */
public interface StreamClient {

    String CHANNEL_NAME ="myMsg";

    @Input(CHANNEL_NAME)
    SubscribableChannel input();

    @Output(CHANNEL_NAME)
    MessageChannel output();
}
