package net.javaguides.springboot.kafka;

import net.javaguides.springboot.model.Employee;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
private KafkaTemplate<String, Employee> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, Employee> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Employee message) {
        kafkaTemplate.send("javaguides", message);
    }

}
