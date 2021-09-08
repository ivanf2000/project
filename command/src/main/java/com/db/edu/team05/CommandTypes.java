package com.db.edu.team05;


public enum CommandTypes {
    SEND("/snd"),
    HISTORY("/hist"),
    CHID("/chid");

    private final String name;

    private CommandTypes(String s) {
        name = s;
    }

    public static boolean isCommand(String command) {
        for (CommandTypes cmd : CommandTypes.values()) {
            if (cmd.equalsName(command))
                return true;
        }
        return false;
    }

    public static CommandTypes getCommandType(String cmd) {
        if (SEND.equalsName(cmd)) return SEND;
        if (HISTORY.equalsName(cmd)) return HISTORY;
        if (CHID.equalsName(cmd)) return CHID;
        return null;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}