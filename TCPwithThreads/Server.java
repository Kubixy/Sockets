package TCPwithThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(6000);

        while (true) {
            Socket client = server.accept();
            MyThread thread = new MyThread(client);
            thread.start();
        }
    }
}
