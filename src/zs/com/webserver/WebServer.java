package zs.com.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Serg on 27.06.2017.
 */
public class WebServer {
    int port;
    private String resourcePath;



    ResourceReader resourceReader = new ResourceReader();


    public void setResourcePath(String resourcePath){
        resourceReader.setResourcePath(resourcePath);
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            Socket socket = serverSocket.accept();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            RequestHandler requestHandler = new RequestHandler(bufferedWriter,bufferedReader,  resourceReader );

            requestHandler.handle();

            bufferedReader.close();
            bufferedWriter.close();

        }
    }


}
