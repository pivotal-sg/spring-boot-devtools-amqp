package io.pivotal.singapore;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

public class Sender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 10000L)
    public void send() {
        final SomeEvent someEvent = new SomeEvent("Added an event", new Date().toString());

        System.out.println(">>>>>>>>>>" + new Date() + ": Sending " + someEvent.toString());

        this.rabbitTemplate.convertAndSend("event", someEvent);
    }
}
