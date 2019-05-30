package com.cactusc9.order.message;

import com.cactusc9.order.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MsgReceiverTest extends OrderApplicationTests {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void msgReceiver() throws InterruptedException {
        amqpTemplate.convertAndSend("myQueue11", new Date().toString());
        Thread.sleep(1000L);
        amqpTemplate.convertAndSend("myQueue11", new Date().toString());
        Thread.sleep(1000L);
        amqpTemplate.convertAndSend("myQueue11", new Date().toString());
    }
}