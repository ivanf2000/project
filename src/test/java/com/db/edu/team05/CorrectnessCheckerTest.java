package com.db.edu.team05;
import com.db.edu.team05.utilities.CorrectnessChecker;
import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CorrectnessCheckerTest {
    @Test
    public void shouldNotSendIncorrectStrings(){
        Collection<Boolean> checkingsList = new ArrayList<>();
        boolean check = true;
        checkingsList.add(CorrectnessChecker.checkIfMessageCorrect(""));
        checkingsList.add(CorrectnessChecker.checkIfMessageCorrect("Message!"));
        checkingsList.add(CorrectnessChecker.checkIfMessageCorrect("/snd"));
        checkingsList.add(CorrectnessChecker.checkIfMessageCorrect("/not_a_command"));
        for (Boolean s : checkingsList){
            check = check & !s;
        }
        assertTrue(check);
    }
}
