package com.db.edu.team05.client;

import java.io.IOException;

public class ClientMessageReceiver {
    public static void main(String[] args) throws IOException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 10_000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            System.out.println(connector.getInput().readLine());
        }
    }
}
