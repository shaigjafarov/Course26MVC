package az.code.course26mvc.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConditionSpecificConsumer {

    @RabbitListener(queues = "condition_queue")
    public void receiveConditionSpecificUpdate(String message) {
        System.out.println("Received condition-specific update: " + message);
    }
}