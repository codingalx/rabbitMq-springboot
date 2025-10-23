package net.aman.springboot_rabbitmq_tutorial.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqProducer.class);

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate; // ✅ must be final for Lombok to inject

    public void sendMessage(String message) {
        LOGGER.info("Sending message -> {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }



}
