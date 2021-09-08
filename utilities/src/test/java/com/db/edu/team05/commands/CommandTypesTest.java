package com.db.edu.team05.commands;

import org.junit.jupiter.api.Test;

import static com.db.edu.team05.commands.CommandTypes.*;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTypesTest {
    @Test
    public void shouldReturnFalseWhenCommandNameIsNotCorrect() {
        assertFalse(isCommand("snd"));
    }

    @Test
    public void shouldReturnTrueWhenCommandNameIsCorrect() {
        assertTrue(isCommand("/snd"));
    }

    @Test
    public void shouldReturnTrueWhenCommandNamesAreEqual() {
        assertTrue(SEND.equalsName("/snd"));
    }

    @Test
    public void shouldReturnFalseWhenCommandNamesAreNotEqual() {
        assertFalse(SEND.equalsName("/hist"));
    }

    @Test
    public void shouldReturnCorrectStringNameOfCommand() {
        assertEquals(SEND.toString(), "/snd");
    }

}