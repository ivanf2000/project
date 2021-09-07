package com.db.edu.team05;


import java.io.IOException;
import java.util.Scanner;

public class ClientMessageSender {
    public static void main(String[] args) throws IOException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 10000);
            connector.getOutput().write("w");
            connector.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            String inputString = new Scanner(System.in).nextLine();
            if (CorrectnessChecker.checkIfMessageCorrect(inputString)) {
                connector.getOutput().write(inputString);
                connector.getOutput().flush();
            } else System.out.println("Incorrect message! Try again:(");

        }

    }
}
