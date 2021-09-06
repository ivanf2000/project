package com.db.edu.team05.client;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class Connector {
    private Socket connection;
    private BufferedReader input;
    private BufferedWriter output;

    public Connector(String host, int port) throws IOException{
        this.connection = new Socket(host, port);
        this.input = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                connection.getInputStream())));
        this.output = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                connection.getOutputStream())));
    }

    public Socket getConnection() {
        return connection;
    }

    public BufferedReader getInput() {
        return input;
    }

    public BufferedWriter getOutput() {
        return output;
    }
}

