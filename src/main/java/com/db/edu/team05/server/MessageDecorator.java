package com.db.edu.team05.server;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageDecorator {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public String decorate(String message) {
        String date = formatter.format(new Date());
        return "[" + date + "] " + message;
    }
}
