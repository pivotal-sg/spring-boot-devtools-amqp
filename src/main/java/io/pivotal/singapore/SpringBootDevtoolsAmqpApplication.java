package io.pivotal.singapore;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableRabbit
@EnableScheduling
public class SpringBootDevtoolsAmqpApplication {

	@Bean
	public Sender mySender() {
		return new Sender();
	}

	@Bean
	public Receiver myReceiver() {
		return new Receiver();
	}

	@Bean
	public Queue eventQueue() {
		return new Queue("event");
	}

	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}


	public static void main(String[] args) {
		// Comment this line to see the error
//		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(SpringBootDevtoolsAmqpApplication.class, args);
	}
}
