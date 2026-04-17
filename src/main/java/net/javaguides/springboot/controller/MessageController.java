package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.KafkaProducer;
import net.javaguides.springboot.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private KafkaProducer kafkaProducer;
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    @PostMapping("publish")
    public String sendMessage(@RequestBody Employee employee) {
        kafkaProducer.sendMessage(employee);
        return "Message sent to Kafka topic successfully";
    }
}
