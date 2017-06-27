package zs.com.webserver;

import com.luxoft.datastructures.map.HashMap;

/**
 * Created by Serg on 27.06.2017.
 */
public class Request {
    HTTPMethod httpMethod;

    String  url;

    String host;


    public String toString(){
        return "URL: "+ url + "   host: "+host+"  httpMethod: "+httpMethod;
    }
}

