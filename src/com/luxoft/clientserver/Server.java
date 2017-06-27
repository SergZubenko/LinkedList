package com.luxoft.clientserver;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Serg on 27.06.2017.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
        Socket socket = serverSocket.accept();


            InputStream inputStream = socket.getInputStream();

            int read;
            while ((read = inputStream.read()) != -1) {
                System.out.println(inputStream.read());
            }
        }

    }
}
