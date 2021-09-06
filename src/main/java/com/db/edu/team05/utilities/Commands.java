package com.db.edu.team05.utilities;

import java.util.ArrayList;
import java.util.Collection;

public class Commands {
    public static final String SEND = "snd";

    public static final String HISTORY = "hist";

    public static final String CHILD = "chid";

    private static Collection<String> commands = new ArrayList<>();

    static {
        commands.add(SEND);
        commands.add(HISTORY);
        commands.add(CHILD);

    }

    public static boolean isCommand(String s){
        return commands.contains(s);
    }


}