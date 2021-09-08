package com.db.edu.team05;

import org.junit.jupiter.api.Test;

import static com.db.edu.team05.CorrectnessChecker.checkIfMessageCorrect;
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
    public void shouldReturnTrueIfCommandIsSnd() {
        assertTrue(checkIfMessageCorrect("/snd message"));
    }

    @Test
    public void shouldReturnFalseIfCommandIsSndWithEmptyBody() {
        assertFalse(checkIfMessageCorrect("/snd"));
    }
}
