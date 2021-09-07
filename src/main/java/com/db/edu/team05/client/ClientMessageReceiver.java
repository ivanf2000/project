package com.db.edu.team05.client;

import com.db.edu.team05.client.Connector;

import java.io.IOException;

public class ClientMessageReceiver {
    public static void main(String[] args) throws IOException, InterruptedException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 10_000);
            connector.getOutput().write("r");
            connector.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            Thread.sleep(3000);
            if(connector.getInput().ready()) {
                char[] buf = new char[150];
                connector.getInput().read(buf);
                System.out.println(String.valueOf(buf));
            } else {
                System.out.println("No message received yet.");
            }
        }
    }
}
