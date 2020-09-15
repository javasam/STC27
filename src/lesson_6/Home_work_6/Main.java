package lesson_6.Home_work_6;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws Throwable {
        ServerSocket ss = new ServerSocket(8001);
        while (true) {
            Socket s = ss.accept();
            System.err.println("Client accepted");
            new Thread(new Server(s)).start();
        }
    }
}
