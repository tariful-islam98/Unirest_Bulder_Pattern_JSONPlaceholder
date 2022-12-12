package base;

public class Properties {
    public static final String JSONPLACEHOLDER_API = "https://jsonplaceholder.typicode.com";
    public static final String REPORT_LOCATION = "target/report/";
//    public static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/gurdeep"; // todo need to make this db the same for all services
    public static final String DB_URL = "jdbc:postgresql://127.0.0.1:5432/cms_db"; // todo need to make this db the same for all services
    public static final String DB_USER = "postgres";
    public static final String DB_PASS = "test";
    public static final String AZURE_SERVICE_BUS_CONN = "Endpoint=sb://exos-test-service-bus.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=YtwVKoCsyCFDM8If9D/glLkspgMx5TiEKiJuo96vz7w=";
    public static final String AZURE_SERVICE_BUS_QUEUE_NAME = "testqueue";

}