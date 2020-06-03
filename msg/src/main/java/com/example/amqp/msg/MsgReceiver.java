package com.example.amqp.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


//@Component
@Slf4j
public class MsgReceiver {


    //@RabbitListener(queuesToDeclare = @Queue("test-queue"))
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue("product-computer"),
                    exchange = @Exchange("defined exchange"),
                    key = "compute"
            )
    )
    public void handleComputerModuleMsg(String msg) {
        log.info("handleComputerModuleMsg:{}",msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue("product-fruit"),
                    exchange = @Exchange("defined exchange"),
                    key = "fruit"
            )
    )
    public void handleFruitProductMsg(String msg) {
        log.info("handleFruitProductMsg:{}",msg);
    }
}
