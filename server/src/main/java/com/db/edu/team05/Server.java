package com.db.edu.team05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String... args) {
        int port = 10000;
        ServerSocket listener = null;
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Collection<Session> sessions = new ArrayList<Session>();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            for (Session session : sessions) {
                try {
                    session.connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));

        ProtocolHandler protocolHandler = new ProtocolHandler(sessions);

        try {
            listener = new ServerSocket(port);
        } catch (IOException e) {
            System.exit(-1);
        }

        while (true) {
            try {
                final Socket connection = listener.accept();
                Session session = new Session(connection);
                sessions.add(session);
                pool.execute(() -> {
                    try {
                        session.initSession();
                        if (session.isWriter()) {
                            while (true) {
                                String message = session.getMessage();
                                protocolHandler.process(message);
                            }
                        } else {

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}

