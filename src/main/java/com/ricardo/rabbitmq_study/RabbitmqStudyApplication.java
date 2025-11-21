package com.ricardo.rabbitmq_study;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RabbitmqStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqStudyApplication.class, args);
	}

}
