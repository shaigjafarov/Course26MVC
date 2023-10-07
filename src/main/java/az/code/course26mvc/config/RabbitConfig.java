package az.code.course26mvc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitConfig {
    @Bean
    public Queue locationQueue() {
        return new Queue("location_queue");
    }

    @Bean
    public Queue conditionQueue() {
        return new Queue("condition_queue");
    }

    @Bean
    public TopicExchange weatherTopicExchange() {
        return new TopicExchange("weather_topic_exchange");
    }

    @Bean
    public Binding locationBinding() {
        return BindingBuilder.bind(locationQueue()).to(weatherTopicExchange()).with("weather.*.location");
    }

    @Bean
    public Binding conditionBinding() {
        return BindingBuilder.bind(conditionQueue()).to(weatherTopicExchange()).with("weather.condition.*");
    }
}
