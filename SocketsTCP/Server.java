package SocketsTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    static final int PORT = 5000;

    public Server() {

        try {

            ServerSocket skServer = new ServerSocket(PORT);

            while (true) {

                Socket skClient = skServer.accept();

                InputStream input = skClient.getInputStream();
                OutputStream output = skClient.getOutputStream();

                DataInputStream inputStream = new DataInputStream(input);
                DataOutputStream outputStream = new DataOutputStream(output);

                outputStream.writeUTF(inputStream.readUTF().toUpperCase());
                skClient.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
