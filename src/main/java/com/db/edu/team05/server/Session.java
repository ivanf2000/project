package com.db.edu.team05.server;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Session {
    Socket connection;
    BufferedReader input;
    BufferedWriter output;
    boolean isWriter;

    public Session(Socket connection) throws IOException {
        this.connection = connection;
    }

    public void initSession() throws IOException {
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
        handShake();

    }

    public BufferedReader getInput() {
        return input;
    }

    public BufferedWriter getOutput() {
        return output;
    }

    public boolean isWriter() {
        return isWriter;
    }

    public String getMessage() throws IOException {
        char[] buf = new char[150];
        input.read(buf);
        return String.valueOf(buf);
    }

    private void handShake() throws IOException {
        char[] buf = new char[1];
        int code = input.read(buf);
        if (code == -1) throw (new IOException());
        switch (buf[0]) {
            case 'w':
                isWriter = true;
                break;
            case 'r':
                isWriter = false;
                break;
            default:
                throw (new IllegalArgumentException());
        }
    }
}
