package net.aman.springboot_rabbitmq_tutorial.consumer;

import net.aman.springboot_rabbitmq_tutorial.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service  // ✅ This makes Spring detect and run this consumer automatically
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    // 🧠 This listens to the JSON queue (name comes from application.yml)
    @RabbitListener(queues = "${spring.rabbitmq.queue.json.name}")
    public void consumeJsonMessage(User user) {
        LOGGER.info(String.format("Received JSON Message -> %s", user));
    }
}
