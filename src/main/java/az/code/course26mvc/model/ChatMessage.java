package az.code.course26mvc.model;

public class ChatMessage {
    private String content;
    private String sender;

    // Constructors, getters, and setters

    public ChatMessage() {
    }

    public ChatMessage(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
