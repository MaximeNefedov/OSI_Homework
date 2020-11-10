package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "localhost";
        // String host = "netology.homework";
        int port = 8081;
        try (Socket clientSocket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {
            //write your name
            String serverResponse = in.readLine();
            System.out.println(serverResponse);

            //sending name
            String name = scanner.nextLine();
            out.println(name);

            //accept message
            serverResponse = in.readLine();
            System.out.println(serverResponse);

            // sending yes or no
            String answer = scanner.nextLine();
            out.println(answer);

            //accept message
            serverResponse = in.readLine();
            System.out.println(serverResponse);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
