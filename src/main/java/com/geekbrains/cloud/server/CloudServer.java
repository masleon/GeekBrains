package com.geekbrains.cloud.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CloudServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8199);
        System.out.println("Server started");
        while (true){
            Socket socket = server.accept();
            new Thread(new CloudFileHandler(socket)).start();
        }
    }
}
