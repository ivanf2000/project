package com.db.edu.team05.commands;

import org.junit.jupiter.api.Test;

import static com.db.edu.team05.commands.CorrectnessChecker.checkIfMessageCorrect;
import static com.db.edu.team05.commands.CorrectnessChecker.checkIfMessageNotLong;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectnessCheckerTest {
    @Test
    public void shouldReturnFalseIfCommandIsEmpty() {
        assertFalse(checkIfMessageCorrect(""));
    }

    @Test
    public void shouldReturnFalseIfCommandIsNotSnd() {
        assertFalse(checkIfMessageCorrect("/log error"));
    }

    @Test
    public void shouldReturnFalseIfCommandIsNotSpecified() {
        assertFalse(checkIfMessageCorrect("qwerty"));
    }

    @Test
    public void shouldReturnTrueIfCommandIsSndAndBodyNotEmpty() {
        assertTrue(checkIfMessageCorrect("/snd message"));
    }

    @Test
    public void shouldReturnFalseIfCommandIsSndWithEmptyBody() {
        assertFalse(checkIfMessageCorrect("/snd"));
    }

    @Test
    public void shouldReturnFalseIfCommandIsMoreThan150Chars () {
        String message = "qwertyuiopasdfg";
        for (int i = 0; i < 4; ++i){
            message = message + message;
        }
        assertFalse(checkIfMessageNotLong(message));
    }
}
