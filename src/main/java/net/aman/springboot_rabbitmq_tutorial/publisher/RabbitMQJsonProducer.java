package net.aman.springboot_rabbitmq_tutorial.publisher;

import lombok.RequiredArgsConstructor;
import net.aman.springboot_rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  // ✅ Automatically injects the final field below
public class RabbitMQJsonProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchange;

    @Value("${spring.rabbitmq.routing-json-key}")
    private String routingJsonKey;

    private final RabbitTemplate rabbitTemplate;  // ✅ Make it final!

    public void sendJsonMessage(User user) {
        LOGGER.info(String.format("Json message sent -> %s", user));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
