package net.javaguides.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.requests.OffsetCommitResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
    public NewTopic javaguidesTopic() {
        return new NewTopic("javaguides", 3, (short) 1);
    }
}
