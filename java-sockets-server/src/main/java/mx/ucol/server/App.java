package mx.ucol.server;

import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) {
        Socket socket;
        int PORT = 5000;
        Thread in;
        Thread out;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server's up!");
            socket = serverSocket.accept();
            System.out.println("A client is connected!");

            in = new Thread(new InputThread(socket));
            in.start();
            out = new Thread(new OutputThread(socket));
            out.start();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}