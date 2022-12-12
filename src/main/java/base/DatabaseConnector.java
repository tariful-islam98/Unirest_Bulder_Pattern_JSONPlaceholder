package base;

import com.aventstack.extentreports.Status;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {


    private static Connection conn = null;

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */

    public static Connection connect() {
        try {
            conn = DriverManager.getConnection(Properties.DB_URL, Properties.DB_USER, Properties.DB_PASS);
            BaseTest.getTestReporter().log(Status.INFO, "Connected to the PostgreSQL database");
        } catch (SQLException e) {
            BaseTest.getTestReporter().log(Status.FAIL, "Failed to connect to the PostrgeSQL database");
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static Connection getConnection() {
        return conn;
    }
}