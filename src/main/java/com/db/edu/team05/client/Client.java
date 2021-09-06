package com.db.edu.team05.client;

import java.io.IOException;

public class Client {
    public static void main(String[] args){
        Connector connector = null;
        try {
            connector = new Connector("localhost", 10_000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread serverMessageAcceptor = new Thread(){
            public void run(){

            }
        };

    }
}
