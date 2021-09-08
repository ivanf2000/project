package com.db.edu.team05;



import com.db.edu.team05.commands.CorrectnessChecker;

import java.io.IOException;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientMessageSender {
    public static void main(String[] args) throws IOException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 8000);
            connector.getOutput().write("w");
            connector.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (!connector.getConnection().isClosed()) {
                String inputString = new Scanner(System.in).nextLine();
                if (CorrectnessChecker.checkIfMessageCorrect(inputString) &&
                        CorrectnessChecker.checkIfMessageNotLong(inputString)) {
                    byte[] bytes = inputString.getBytes();
                    String inputUTF8 = new String(bytes, StandardCharsets.UTF_8);
                    connector.getOutput().write(inputUTF8);
                    connector.getOutput().flush();
                } else System.out.println("Incorrect message! Try again:(");

            }
        } catch (SocketException e) {
            System.out.println("Server interrupt connection");
        }
    }
}
