package com.db.edu.team05;

import java.io.IOException;

public class ClientMessageReceiver {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 8000);
            connector.getOutput().write("r");
            connector.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!connector.getConnection().isClosed()) {
            Thread.sleep(3000);
            if (connector.getInput().ready()) {
                char[] buf = new char[150];
                connector.getInput().read(buf);
                String message = String.valueOf(buf);
                message = message.substring(0, message.indexOf('\0'));
                System.out.println(message);
            }
        }
        System.out.println("Server interrupt connection");
    }
}
