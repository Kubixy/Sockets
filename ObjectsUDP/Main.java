package ObjectsUDP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(1556);
            Socket socket = server.accept();

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Car car = (Car) input.readObject();

            System.out.println(car.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
