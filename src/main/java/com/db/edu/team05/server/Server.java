package com.db.edu.team05.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

    public class Server {
        private final int port;
        final ServerSocket listener;
        ProtocolHandler protocolHandler;

        public Server(int port) throws IOException {
            this.port = port;
            this.listener = new ServerSocket(port);
            this.protocolHandler = new ProtocolHandler();
        }

        public void oneServer() {
            try (
//                listener.setSoTimeout();
                    final Socket connection = listener.accept();
            ) {
                    Session session = new Session(connection);
                    if(session.isWriter()){
                        while(true) {
                            String message = session.getMessage();
                            protocolHandler.process(message);
                        }
                    }
//                    if(!session.isWriter()){
//                        while(true) {
//
//                        }
//                    }

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

//            while (true) {
//                        final String read = input.readUTF();
//                        output.writeUTF(">>>>>>> " + read);
//                        output.flush();
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace(System.err);
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace(System.err);
//            }
//        }
//    }

