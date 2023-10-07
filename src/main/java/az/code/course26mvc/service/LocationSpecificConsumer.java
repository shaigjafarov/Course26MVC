package az.code.course26mvc.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class LocationSpecificConsumer {

    @RabbitListener(queues = "location_queue")
    public void receiveLocationSpecificUpdate(String message) {
        System.out.println("Received location-specific update: " + message);
    }
}

