package az.code.course26mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@EnableWebSocketMessageBroker

@SpringBootApplication
public class Course26MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Course26MvcApplication.class, args);
    }

}
