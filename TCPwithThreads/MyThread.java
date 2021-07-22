package TCPwithThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.Thread;
import java.net.Socket;

public class MyThread extends Thread {

    BufferedReader input;
    PrintWriter output;
    Socket socket;

    public MyThread(Socket socket) throws IOException {
        this.socket = socket;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        String text = "";

        do {
            try {

                text = input.readLine();
                output.println(text.toUpperCase());

            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!text.equals("*"));

        output.close();

        try {
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
