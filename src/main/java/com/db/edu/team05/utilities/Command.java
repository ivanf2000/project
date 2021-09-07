package com.db.edu.team05.utilities;


public class Command {
    private Commands cmd;
    private String body;

    public Command(String message) {
        int spacePos = message.indexOf(' ');
        boolean isWithBody = spacePos != -1 ? true : false;
        String cmd = message.substring(0, isWithBody ? spacePos : message.length());
        this.cmd = Commands.getCommandType(cmd);
        this.body = isWithBody ? message.substring(spacePos + 1) : null;
//        String[] parsedCommand = message.split(" ");
    }

    public Commands getCmd() {
        return cmd;
    }

    public String getBody() {
        return body;
    }
}
