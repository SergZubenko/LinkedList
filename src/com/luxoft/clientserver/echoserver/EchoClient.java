package com.luxoft.clientserver.echoserver;

import java.io.*;
import java.net.Socket;

/**
 * Created by Serg on 27.06.2017.
 */
public class EchoClient {


    public static void main(String[] args) throws IOException {
        String inputString;
        String responceString;
        Socket socket = new Socket("localhost", 3000);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedServerReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        while (true) {
            inputString = bufferedReader.readLine();

            if ("exit".equals(inputString)) {
                break;
            }

            System.out.println("Input : " + inputString);
            bufferedWriter.write(inputString);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            try {
                responceString = bufferedServerReader.readLine();
                System.out.println("responce :  " + responceString);
            } catch (IOException e) {
                break;
            }


        }
    }
}

