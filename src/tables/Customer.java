package tables;

import database.DatabaseConnection;
import java.sql.*;

public class Customer {

    private Connection conn;

    public Customer() {
        conn = DatabaseConnection.getConnection();
    }
}
