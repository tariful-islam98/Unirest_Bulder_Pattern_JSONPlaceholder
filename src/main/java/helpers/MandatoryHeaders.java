package helpers;

import base.HttpHeader;
import base.TestData;

import java.util.HashMap;
import java.util.UUID;

public class MandatoryHeaders {


    public static HttpHeader getHeaders() {
        HashMap<String, String> map = new HashMap<>();
//        map.put("correlation-id", UUID.randomUUID().toString());
//        map.put("x-correlation-id", UUID.randomUUID().toString());
//        map.put("login-name", TestData.NAME);
//        map.put("email", TestData.EMAIL_ADDRESS);
//        map.put("full-name", "Automation Test");
        map.put("Content-Type", "application/json");
        map.put("Accept", "*/*");

        HttpHeader headers = new HttpHeader();
        headers.setHeaders(map);
        return headers;
    }

}
