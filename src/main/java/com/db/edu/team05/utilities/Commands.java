package com.db.edu.team05.utilities;

import java.util.ArrayList;
import java.util.Collection;

//public class Commands {
//    public static final String SEND = "snd";
//
//    public static final String HISTORY = "hist";
//
//    public static final String CHID = "chid";
//
//    private static Collection<String> commands = new ArrayList<>();
//
//    static {
//        commands.add(SEND);
//        commands.add(HISTORY);
//        commands.add(CHID);
//
//    }
//
//    public static boolean isCommand(String s){
//        return commands.contains(s);
//    }
//
//
//}

public enum Commands {
    SEND ("/snd"),
    HISTORY ("/hist"),
    CHID ("/chid");

    private final String name;

    private Commands(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

    public static boolean isCommand(String command) {
        for (Commands cmd : Commands.values()) {
            if (cmd.equalsName(command))
                return true;
        }
        return false;
    }

    public static Commands getCommandType(String cmd) {
        if (SEND.equalsName(cmd)) return SEND;
        if (HISTORY.equalsName(cmd)) return HISTORY;
        if (CHID.equalsName(cmd)) return CHID;
        return null;
    }

}