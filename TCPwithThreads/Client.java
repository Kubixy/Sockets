package TCPwithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 6000)) {

            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String text;

            do {

                output.println(in.readLine());
                text = input.readLine();
                System.out.println(text);

            } while (!text.equals("*"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
