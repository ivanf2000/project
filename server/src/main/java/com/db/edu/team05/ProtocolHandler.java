package com.db.edu.team05;

import java.io.IOException;
import java.util.Collection;

public class ProtocolHandler {
    Collection<Session> sessions;
    MessageDecorator decorator = new MessageDecorator();

    public ProtocolHandler(Collection<Session> sessions) {
        this.sessions = sessions;
    }

    public void process(String message) throws IOException {
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
