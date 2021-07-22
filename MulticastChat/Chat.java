package MulticastChat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.*;

public class Chat extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    final static String INET_ADDR = "224.0.0.7";
    final static int PORT = 8888;
    MulticastSocket clientSocket;
    DatagramPacket msgPacket = null, msgPacket2 = null;
    TextArea chat;
    byte[] buffer;
    InetAddress address;

    public void getData() {

        try {
            clientSocket = new MulticastSocket(PORT);
            clientSocket.joinGroup(address);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {

            buffer = new byte[256];
            msgPacket2 = new DatagramPacket(buffer, buffer.length);

            try { clientSocket.receive(msgPacket2); }
            catch (IOException e) { e.printStackTrace(); }

            chat.appendText(new String(buffer, 0 , buffer.length) + "\n");
        }
    }

    @Override
    public void start(Stage primaryStage) throws UnknownHostException {

        chat = new TextArea();
        TextField input = new TextField();
        Button send = new Button("Send");

        VBox mainBox = new VBox(chat, input, send);
        mainBox.setSpacing(20);

        primaryStage.setTitle("Multicast Chat");
        primaryStage.setScene(new Scene(mainBox, 300, 275));
        primaryStage.show();

        address = InetAddress.getByName(INET_ADDR);

        send.setOnAction(e -> {

            try (DatagramSocket server = new DatagramSocket()) {

                String output = input.getText();
                msgPacket = new DatagramPacket(
                        output.getBytes(),
                        output.getBytes().length,
                        address,
                        PORT
                );

                server.send(msgPacket);
                input.clear();

            } catch (IOException socketException) {
                socketException.printStackTrace();
            }

        });

        new Thread(this::getData).start();
    }
}
