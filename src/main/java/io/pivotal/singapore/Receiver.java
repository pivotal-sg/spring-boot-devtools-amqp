package io.pivotal.singapore;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.util.Date;

@RabbitListener(queues = "event")
public class Receiver {

    @RabbitHandler
    public void process(SomeEvent someEvent) {
        System.out.println("<<<<<<<<<<" + new Date() + ": Receiving " + someEvent.toString());
    }
}
