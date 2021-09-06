package com.db.edu.team05.utilities;


public class Message {
    private String commandType;
    private String body;

    public Message(String message) {
        this.commandType = message.substring(1, message.indexOf(' '));
        this.body = message. substring(message.indexOf(' ') + 1);
    }
}