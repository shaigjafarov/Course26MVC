package az.code.course26mvc.controller;

import az.code.course26mvc.model.ChatMessage;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller


public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat")
//    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message) {

        System.out.println(message.getContent());
        message.setContent(message.getContent()+" TEST");
//        return message;
        messagingTemplate.convertAndSend("/topic/messages", message);
return message;
    }


//    @MessageMapping("/send-message")
//    public void sendMessage(String message) {
//        // Get the userId from the authentication context
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String userId = authentication.getName();
//
//        // Send the message to the specified user
//        messagingTemplate.convertAndSendToUser(userId, "/queue/reply", message);
//    }



    @GetMapping("/message")
    String getMessagePage(){
        return "messaging";
    }






}