package com.example.producer.producer;

public interface RabbitMQProducerService {

    void sendMessage(String message, String routingKey);
}
