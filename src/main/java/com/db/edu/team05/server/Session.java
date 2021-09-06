package com.db.edu.team05.server;

import java.io.*;
import java.net.Socket;

public class Session {
    Socket connection;
    final BufferedReader input;
    final BufferedWriter output;
    boolean isWriter;

    public Session(Socket connection) throws IOException {
        this.connection = connection;
         this.input = new BufferedReader(
                new InputStreamReader(
                        new BufferedInputStream(
                                connection.getInputStream())));
        this.output = new BufferedWriter(
                new OutputStreamWriter(
                        new BufferedOutputStream(
                                connection.getOutputStream())));
        handShake();
    }

    public boolean isWriter(){
        return isWriter;
    }

    public String getMessage() throws IOException {
        return input.readLine();
    }

    private void handShake() throws IOException {
        char[] buf = new char[1];
        int code = input.read(buf);
        if(code == -1) throw(new IOException());
        switch(buf[0]) {
            case 'w' :
                isWriter = true;
                break;
            case 'r' :
                isWriter = false;
                break;
            default:
                throw(new IllegalArgumentException());
        }
    }
}
