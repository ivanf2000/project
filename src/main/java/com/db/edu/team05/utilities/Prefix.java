package com.db.edu.team05.utilities;

import java.util.ArrayList;
import java.util.Collection;

public class Prefix {
    public static final String SEND = "snd";

    public static final String HISTORY = "hist";

    public static final String CHILD = "chid";

    private static Collection<String> prefixes = new ArrayList<>();

    static {
        prefixes.add(SEND);
        prefixes.add(HISTORY);
        prefixes.add(CHILD);

    }

    public static boolean isPrefix(String s){
        return prefixes.contains(s);
    }


}