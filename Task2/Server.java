package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Write your name");
            String name = in.readLine();
            out.println("Are you child? (yes/no)");
            String clientResponse = in.readLine();

            if (clientResponse.equals("no")) {
                out.println(String.format("Welcome to the adult zone, %s!" +
                        " Have a good rest, or a good working day!", name));
            } else {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
