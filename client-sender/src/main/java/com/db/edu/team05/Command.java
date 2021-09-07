package com.db.edu.team05;


public class Command {
    private CommandTypes cmd;
    private String body;

    public Command(String message) {
        int spacePos = message.indexOf(' ');
        boolean isWithBody = spacePos != -1;
        String cmd = message.substring(0, isWithBody ? spacePos : message.length());
        this.cmd = CommandTypes.getCommandType(cmd);
        this.body = isWithBody ? message.substring(spacePos + 1) : null;
    }

    public CommandTypes getCmd() {
        return cmd;
    }

    public String getBody() {
        return body;
    }
}
