package com.db.edu.team05.server;

import com.db.edu.team05.utilities.Commands;
import com.db.edu.team05.utilities.Command;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public class ProtocolHandler {
    Collection<Session> sessions;
//    CommandParser parser = new CommandParser();
    MessageDecorator decorator = new MessageDecorator();
    public ProtocolHandler(Collection<Session> sessions) {
        this.sessions = sessions;
    }

    public void process(String message) throws IOException {
        System.out.println(message);
        Command command = new Command(message);
        switch (command.getCmd()) {
            case SEND:
                String decoratedMessage = decorator.decorate(command.getBody());
                for (Session connection : sessions) {
                    if (!connection.isWriter()) {
                        connection.getOutput().write(decoratedMessage);
                        connection.getOutput().flush();
                    }
                }
                break;
            default:
                System.out.println("Unknown command received" + command);
        }
    }


}
