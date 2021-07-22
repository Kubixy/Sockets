package SocketsTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static final String HOST = "localhost";
    static final int PORT = 5000;
    Scanner userInput = new Scanner(System.in);

    public Client() {

        try {

            Socket skClient = new Socket(HOST, PORT);

            InputStream input = skClient.getInputStream();
            OutputStream output = skClient.getOutputStream();

            DataInputStream inputStream = new DataInputStream(input);
            DataOutputStream outputStream = new DataOutputStream(output);

            outputStream.writeUTF(userInput.nextLine());
            System.out.println(inputStream.readUTF());

            skClient.close();

        } catch (Exception ignored) {}

    }

    public static void main(String[] args) {
        new Client();
    }
}
