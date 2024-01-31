package com.example.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class RabbitMQConsumer {

    @RabbitListener(queues = "${spring.rabbitmq.myQueue}")
    public void processMyQueue(String message) {
        System.out.printf("Выводи сообщение из очереди : %s ", new String(message.getBytes()));
    }
}
