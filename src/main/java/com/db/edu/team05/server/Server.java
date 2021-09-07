package com.db.edu.team05.server;

import java.io.*;
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
            ProtocolHandler protocolHandler = new ProtocolHandler(sessions);
            try {
                listener = new ServerSocket(port);
            } catch (IOException e) {
                System.exit(-1);
            }

            for (int i = 0; i < 2; i++) {
                System.out.println(i==0 ? "Wait for ClientReceiver" : "Wait for ClientSender");
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

