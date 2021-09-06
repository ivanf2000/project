package com.db.edu.team05.server;

import com.db.edu.team05.utilities.Commands;

public class ProtocolHandler {
CommandParser parser = new CommandParser();

    public void process(String message){
        Command command = parser.parse(message);
        switch (command.getCmd()) {
            Commands.SEND :
        }
    }


}
