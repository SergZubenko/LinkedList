package com.luxoft.clientserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * Created by Serg on 27.06.2017.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(10);
        outputStream.write(20);
        outputStream.write(30);
        outputStream.write(40);
        outputStream.close();
    }


}
