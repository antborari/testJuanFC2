package com.example.testjuanfc.chat.data;

public class MessageDTO {
    private String message;
    private int type;

    public MessageDTO() {
    }

    public MessageDTO(String message, int type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
