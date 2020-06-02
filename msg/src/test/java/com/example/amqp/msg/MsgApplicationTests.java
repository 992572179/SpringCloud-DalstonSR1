package com.example.amqp.msg;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsgApplicationTests {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testMsgSender(){
        //amqpTemplate.convertAndSend("test-queue","hello amqp!");
        amqpTemplate.convertAndSend("defined exchange","fruit","send fruit msg-> amqp!");
    }

}
