package net.aman.springboot_rabbitmq_tutorial.controller;


import lombok.RequiredArgsConstructor;
import net.aman.springboot_rabbitmq_tutorial.dto.User;
import net.aman.springboot_rabbitmq_tutorial.publisher.RabbitMQJsonProducer;
import net.aman.springboot_rabbitmq_tutorial.publisher.RabbitMqProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")

public class MessageJsonController {
    private final RabbitMQJsonProducer  rabbitMQJsonProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }
}
