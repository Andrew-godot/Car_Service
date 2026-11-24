package tables;

import database.DatabaseConnection;
import java.sql.*;

public class Car {

    private Connection conn;

    public Car() {
        conn = DatabaseConnection.getConnection();
    }
}
