package zs.com.webserver;

import com.luxoft.clientserver.Server;

import javax.sql.rowset.serial.SerialRef;
import java.io.IOException;

/**
 * Created by Serg on 27.06.2017.
 */
public class Starter {
    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        webServer.setPort(3000);
        webServer.setResourcePath("resources");
        try {
            webServer.start();
            System.out.println("server started");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
