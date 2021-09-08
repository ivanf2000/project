package com.db.edu.team05.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.db.edu.team05.commands.CommandTypes.SEND;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {
    private String message;
    private Command command;

    @BeforeEach
    public void setUp () {
        message = "/snd hello world";
        command = new Command(message);
    }

    @Test
    public void shouldReturnBody () {
        assertEquals("hello world", command.getBody());
    }

    @Test
    public void shouldReturnCommand () {
        assertEquals(SEND, command.getCmd());
    }
}