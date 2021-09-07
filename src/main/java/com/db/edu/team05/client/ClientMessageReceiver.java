package com.db.edu.team05.client;

import java.io.IOException;

public class ClientMessageReceiver {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 10000);
            connector.getOutput().write("r");
            connector.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Thread.sleep(3000);
            if (connector.getInput().ready()) {
                char[] buf = new char[150];
                connector.getInput().read(buf);
                String message = String.valueOf(buf);
                message = message.substring(0, message.indexOf('\0'));
                System.out.println(message);
            }
        }
    }
}
