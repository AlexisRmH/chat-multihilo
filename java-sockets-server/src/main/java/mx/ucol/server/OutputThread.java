
package mx.ucol.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OutputThread implements Runnable {
    private DataOutputStream outStream;
    private String outData;
    private Scanner scanner;

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
            while (true){
                scanner = new Scanner(System.in);
                outData = scanner.nextLine();
                outStream.writeUTF(outData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}