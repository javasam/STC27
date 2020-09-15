package lesson_6.Home_work_6;


import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

class Server implements Runnable {

    private Socket s;
    private InputStream is;
    private OutputStream os;
    FolderList folderList = new FolderList();
    String str = folderList.showFolderList().toString();

    Server(Socket s) throws Throwable {
        this.s = s;
        this.is = s.getInputStream();
        this.os = s.getOutputStream();
    }

    public void run() {
        try {
            readInputHeaders();
            writeResponse(str);
        } catch (Throwable t) {
        } finally {
            try {
                s.close();
            } catch (Throwable t) {
            }
        }
        System.err.println("Client processing finished");
    }

    private void writeResponse(String s) throws Throwable {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + s.length() + "\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + s;
        os.write(result.getBytes());
        os.flush();
    }

    private void readInputHeaders() throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while (true) {
            String s = br.readLine();
            if (s == null || s.trim().length() == 0) {
                break;
            }
        }
    }

}
