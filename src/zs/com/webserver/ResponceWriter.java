package zs.com.webserver;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by Serg on 27.06.2017.
 */
public class ResponceWriter {

    private String getREsponceHandle(Boolean sucess){
        if (sucess){
            return "HTTP/1.0 200 OK";
        } else
        {
            return "HTTP/1.0 500 Internal Server Error";
        }
    }

    public void writeResponce(BufferedWriter bufferedWriter, String responce, boolean success) throws IOException {

            bufferedWriter.write(getREsponceHandle(success));
            bufferedWriter.newLine();
            //bufferedWriter.write("Content-Type: text/html; charset=UTF-8");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write(responce);
            bufferedWriter.newLine();
            bufferedWriter.flush();

    }

}
