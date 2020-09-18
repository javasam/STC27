package lesson_6.Home_work_6;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

class MyHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        handleResponse(httpExchange);
    }

    private void handleResponse(HttpExchange httpExchange) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        String htmlResponse = "";
        FolderList folderList = new FolderList();

        if ("GET".equals(httpExchange.getRequestMethod())) {
            htmlResponse = "Hello! It works! <br> Dude, you are blowing up. Your files: " + folderList.showFolderList();
            // Header
            httpExchange.sendResponseHeaders(200, htmlResponse.length());
            outputStream.write(htmlResponse.getBytes());
        } else if ("POST".equals(httpExchange.getRequestMethod())) {
            // Header
            htmlResponse = "404 Not Found";
            httpExchange.sendResponseHeaders(404, htmlResponse.length());
            outputStream.write(htmlResponse.getBytes());
        }
        outputStream.flush();
        outputStream.close();
    }
}
