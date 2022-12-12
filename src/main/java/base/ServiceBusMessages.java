package base;

import java.util.HashMap;

public class ServiceBusMessages {

    private static HashMap<String,String> messages = new HashMap<>();


    public static void add(String key, String message) {
        messages.put(key, message);
    }

    public static HashMap<String, String> getAll() {
        return messages;
    }

    public static String get(String key) {
        return messages.get(key);
    }


}
