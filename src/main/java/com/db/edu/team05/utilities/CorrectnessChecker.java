package com.db.edu.team05.utilities;

public class CorrectnessChecker {
    public static boolean checkIfMessageCorrect(String inputString){
        if (inputString.isEmpty()) return false;
        if (inputString.charAt(0) != '/') return false;
        if (inputString.indexOf(' ') == -1) return Commands.HISTORY.equals(inputString.substring(1));
        return Commands.isCommand(inputString.substring(1, inputString.indexOf(' ')));
    }
}
