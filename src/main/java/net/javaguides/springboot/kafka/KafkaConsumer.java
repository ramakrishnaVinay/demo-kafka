package net.javaguides.springboot.kafka;

import net.javaguides.springboot.model.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "javaguides", groupId = "group_id")
    public void consumeMessage(Employee emp) {
        System.out.println("ID: " + emp.getID());
        System.out.println("Name: " + emp.getFirstName());
        System.out.println("Email: " + emp.getEmail());

    }
}
