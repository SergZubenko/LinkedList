package zs.com.webserver;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Serg on 27.06.2017.
 */
public class RequestParcer {

    public static Request parceRequest(BufferedReader bufferedReader) throws IOException {

/*
        GET /dsfdsdsfsd HTTP/1.1
        Host: localhost:3000
        Connection: keep-alive
*/

        Request request = new Request();

        String line = bufferedReader.readLine();
        String[] headers = line.split(" ");
        request.httpMethod = HTTPMethod.valueOf(headers[0]);
        request.url = headers[1];
        System.out.println(line);
        System.out.println(request);
        return request;
    }

}
