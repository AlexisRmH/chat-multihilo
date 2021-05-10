package mx.ucol.client;

import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;

public class InputThread implements Runnable {
    private String inData;
    private DataInputStream inStream;

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
                System.out.println("Message from server: " + inData);
            } while(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}