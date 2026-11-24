package tables;

import database.DatabaseConnection;
import java.sql.*;

public class Job {

    private Connection conn;

    public Job() {
        conn = DatabaseConnection.getConnection();
    }
}