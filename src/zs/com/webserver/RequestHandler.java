package zs.com.webserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Serg on 27.06.2017.
 */
public class RequestHandler {
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private ResourceReader resourceReader;

    public RequestHandler(BufferedWriter bufferedWriter, BufferedReader bufferedReader, ResourceReader resourceReader) {
        this.bufferedWriter = bufferedWriter;
        this.bufferedReader = bufferedReader;
        this.resourceReader = resourceReader;
    }


    public void handle(){

        ResponceWriter responceWriter = new ResponceWriter();
        Request request = null;
        try {
            request = RequestParcer.parceRequest(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
            try {
                responceWriter.writeResponce(bufferedWriter, "Requested source not found ", false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        try {
            String responce = resourceReader.readResource(request.url);
            responceWriter.writeResponce(bufferedWriter, responce, true);
        }
        catch(Exception e) {
            e.printStackTrace();
            try {
                responceWriter.writeResponce(bufferedWriter, "Requested source not found ", false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }

}
