package zs.com.webserver;

import java.io.*;

/**
 * Created by Serg on 27.06.2017.
 */
public class ResourceReader {

    private String resourcePath;

    public String readResource(String url) throws IOException {
        url = resourcePath+url;
        System.out.println("Requested url: "+url);
        FileReader fileReader = new FileReader(url);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
            stringBuilder.append(line);
            stringBuilder.append('\n');
        }

        return stringBuilder.toString();
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }
}
