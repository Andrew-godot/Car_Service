package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Attributes
    private static final String url = "jdbc:mariadb://localhost:3306/car_service"; // database url
    private static final String user = "root"; // username
    private static final String password = "root"; // password

    // Establishes a database connection
    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, password);
    }

    // Method
    public static void displayExecutionTime(int rowCount, long startTime) {

        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;

        StackTraceElement caller = Thread.currentThread().getStackTrace()[2];

        String methodName = caller.getMethodName();
        String className = caller.getClassName();

        if (className.startsWith("tables.") &&
                (methodName.equals("insertStatement") ||
                        methodName.equals("updateStatement") ||
                        methodName.equals("deleteStatement"))) {

            System.out.printf("QUERY OK, 1 row affected (%.3f sec)\n", executionTime);

        }
        else {
            System.out.println("-------------------------\n" + rowCount + " rows in set (" + String.format("%.3f", executionTime / 1000) + " sec)");
        }
    }
}