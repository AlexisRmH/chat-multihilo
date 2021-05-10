package mx.ucol.client;

import java.net.*;

public class App {
    public static void main( String[] args )
    {
        Socket socket;
        int PORT = 5000;
        String HOST = "127.0.0.1";
        Thread in;
        Thread out;


        try {
            socket = new Socket(HOST, PORT);
            System.out.println("Connection established");

            in = new Thread(new InputThread(socket));
            in.start();
            out = new Thread(new OutputThread(socket));
            out.start();n
        } catch (Exception e) {
            System.err.print(e);
        }
    }
}
