package com.db.edu.team05;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageDecoratorTest {
    @Test
    public void shouldWriteDateBeforeMessage () {
        String message = "hello world";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String date = formatter.format(new Date());
        MessageDecorator messageDecorator = new MessageDecorator();
        assertEquals(messageDecorator.decorate(message), "[" + date + "] " + message);
    }
}
