package com.db.edu.team05.commands;

public class CorrectnessChecker {
    public static boolean checkIfMessageCorrect(String inputString) {
        if (inputString.isEmpty()) return false;
        if (inputString.charAt(0) != '/') return false;
        if (inputString.indexOf(' ') == -1) return CommandTypes.HISTORY.equalsName(inputString);
        return CommandTypes.isCommand(inputString.substring(0, inputString.indexOf(' ')));
    }

    public static boolean checkIfMessageNotLong(String inputString){
        return inputString.length()<=150;
    }
}