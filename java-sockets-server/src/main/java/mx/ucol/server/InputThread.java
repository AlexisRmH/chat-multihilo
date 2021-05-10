package mx.ucol.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class InputThread implements Runnable {
    private DataInputStream inStream;
    private String inData;

    public InputThread(Socket socket) {
        try {
            inStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            inData = "";
            do {
                inData = inStream.readUTF();
                System.out.println("Message from client: " + inData);
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}