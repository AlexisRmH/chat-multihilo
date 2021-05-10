package mx.ucol.client;

import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;
import java.io.DataOutputStream;


public class OutputThread implements Runnable {
    private String outData;
    private DataOutputStream outStream;
    private Scanner scanner;
    private boolean wantToExit;

    public OutputThread(Socket socket) {
        try {
            outStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try {
            outData = "";
            do {
                scanner = new Scanner(System.in);
                outData = scanner.nextLine();
                outStream.writeUTF(outData);
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}