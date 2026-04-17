
import net.javaguides.springboot.kafka.KafkaConsumer;
import net.javaguides.springboot.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class KafkaConsumerTest {

    @InjectMocks
    private KafkaConsumer kafkaConsumer;

    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        outputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    void testConsumeMessage() {
        Employee emp = new Employee();
        emp.setID(1L);
        emp.setFirstName("John");
        emp.setEmail("john@example.com");

        kafkaConsumer.consumeMessage(emp);

        String output = outputStream.toString();
        assertTrue(output.contains("ID: 1"));
        assertTrue(output.contains("Name: John"));
        assertTrue(output.contains("Email: john@example.com"));
    }

    @Test
    void testConsumeMessageWithDifferentData() {
        Employee emp = new Employee();
        emp.setID(2L);
        emp.setID(2L);
        emp.setFirstName("Jane");
        emp.setEmail("jane@example.com");

        kafkaConsumer.consumeMessage(emp);

        String output = outputStream.toString();
        assertTrue(output.contains("ID: 2"));
        assertTrue(output.contains("Name: Jane"));
        assertTrue(output.contains("Email: jane@example.com"));
    }
}
