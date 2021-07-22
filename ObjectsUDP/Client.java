package ObjectsUDP;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {

            Socket socket = new Socket("localhost", 1556);
            ObjectOutputStream stream = new ObjectOutputStream(socket.getOutputStream());
            stream.flush();

            System.out.println("Introduce your id and plate");
            Car car = new Car(input.nextLine(), input.nextLine());

            stream.writeObject(car);
            System.out.println("Object sent");

            stream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
