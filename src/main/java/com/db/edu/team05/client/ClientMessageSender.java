package com.db.edu.team05.client;

import com.db.edu.team05.utilities.CorrectnessChecker;
import com.db.edu.team05.utilities.Message;

import java.io.IOException;
import java.util.Scanner;

public class ClientMessageSender {
    public static void main(String[] args) throws IOException {
        Connector connector = null;
        try {
            connector = new Connector("localhost", 10_000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            String inputString  = new Scanner(System.in).nextLine();
            if (CorrectnessChecker.checkIfMessageCorrect(inputString)){
                connector.getOutput().write(inputString);
//                System.out.println("Check passed");
            }
            else System.out.println("Incorrect message! Try again:(");

        }

    }
}
