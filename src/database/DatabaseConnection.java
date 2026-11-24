package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:mariadb://localhost:3306/car_service?sslMode=trust";
    private static final String user = "root";
    private static final String password = "root";

    public static Connection getConnection() {

        try {
            return DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
