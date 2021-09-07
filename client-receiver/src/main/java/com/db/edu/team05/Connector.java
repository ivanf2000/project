package com.db.edu.team05;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Connector {
    private Socket connection;
    private BufferedReader input;
    private BufferedWriter output;

    public Connector(String host, int port) throws IOException {
        this.connection = new Socket(host, port);
        this.input = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                connection.getInputStream()),
                        StandardCharsets.UTF_8), 150);
        this.output = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                connection.getOutputStream()),
                        StandardCharsets.UTF_8), 150);
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

