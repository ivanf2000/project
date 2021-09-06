package com.db.edu.team05.client;

import java.io.*;
import java.net.Socket;

public class Connector {
    private Socket connection;
    private DataInputStream input;
    private DataOutput output;

    public Connector(String host, int port) {

            this.connection = new Socket(host, port);
            this.input = this.connection.getInputStream();
            this.output = this.connection.getOutputStream();
    }
}
