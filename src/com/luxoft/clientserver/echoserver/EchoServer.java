package com.luxoft.clientserver.echoserver;

import com.luxoft.datastructures.list.ArrayList;
import com.luxoft.datastructures.list.List;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Serg on 27.06.2017.
 */
public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        while (true) {
            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));


            while (true) {
                String line;
                try {
                    line = bufferedReader.readLine();
                    System.out.println(line);

                    if("server exit".equals(line)){
                        break;
                    }
                    //System.out.println("Sleeping 4000");
                    //Thread.sleep(4000);
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (IOException e) {
                    break;
                }

            }
            bufferedReader.close();
            bufferedWriter.close();
        }
    }
}




