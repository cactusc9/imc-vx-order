package com.cactusc9.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author cactus
 */
@Slf4j
@Component
public class MsgReceiver {

    @RabbitListener(queuesToDeclare =@Queue("myQueue11"))
    public void process(String receiver) {
        log.info("receiver: {}", receiver);
    }

}
