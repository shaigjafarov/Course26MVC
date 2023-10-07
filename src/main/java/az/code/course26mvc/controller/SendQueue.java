package az.code.course26mvc.controller;

import az.code.course26mvc.model.WeatherDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/queue")
public class SendQueue {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostMapping
    void sendQueueMessage(@RequestBody WeatherDTO weather) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(weather.getHavaProqnozuDTO());
        String routingKey = "weather." + weather.getLocation() + "." + weather.getCondition();
        amqpTemplate.convertAndSend("weather_topic_exchange", routingKey, message);
    }
}
