package com.db.edu.team05.client;

import com.db.edu.team05.client.Connector;

import java.io.IOException;

public class ClientMessageReceiver {
    public static void main(String[] args) throws IOException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 10_000);
            connector.getOutput().write("r");
            connector.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        while (true){
            if(connector.getInput().ready()) {
                System.out.println(connector.getInput().readLine());
            } else {
                System.out.println("No message received yet.");
            }
//        }
    }
}
