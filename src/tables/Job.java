package tables;

// IMPORTS
import database.DatabaseConnection;
import java.sql.*;
import java.util.Arrays;

public class Job {

    // ATTRIBUTES
    private Connection conn;

    public Job() {
        try {
            conn = DatabaseConnection.getConnection();
            System.out.println("Database connected successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // METHODS
    public void selectStatement() throws SQLException {

        long startTime = System.nanoTime();
        int rowCount = 0;

        String sql_select = "SELECT * FROM car_service.job";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql_select);

        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
            rowCount++;
        }

        DatabaseConnection.displayExecutionTime(rowCount, startTime);
    }

    public void insertStatement(String insertData) {

        String sql_insert = "INSERT INTO car_service.job VALUES(?, ?, ?, ?, ?, ?)";

        try {
            String[] storedData = insertData.split(",");

            if (storedData.length != 6) {
                System.out.println("Please enter exactly 6 values.");
                return;
            }

            if (checkExistingPrimary(storedData)) {
                System.out.printf("ERROR 1062 (23000): Duplicate entry '%s' for key 'PRIMARY'\n", storedData[0]);
            } else {
                PreparedStatement ps = conn.prepareStatement(sql_insert);

                for (int i = 0; i < storedData.length; i++) {
                    ps.setString(i + 1, storedData[i].trim());

                }

                int row = ps.executeUpdate();
                System.out.println(row);

                ps.close();

                long startTime = System.nanoTime();
                int rowCount = 0;

                DatabaseConnection.displayExecutionTime(rowCount, startTime);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatement(String jobID, String column, String newValue) {

        String[] allowedColumns = {
                "garageID",
                "dateIn",
                "dateOut",
                "regNo",
                "cost"
        };

        if (!Arrays.asList(allowedColumns).contains(column)) {
            System.out.println("Invalid column selected!");
            return;
        }

        String sql_update = "UPDATE car_service.job SET " + column + " = ? WHERE jobID = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql_update)) {

            ps.setString(1, newValue);
            ps.setString(2, jobID);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Job data successfully updated!");
            } else {
                System.out.println("Job ID not found.");
            }

            long startTime = System.nanoTime();
            int rowCount = 0;

            DatabaseConnection.displayExecutionTime(rowCount, startTime);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStatement(String deleteData) throws SQLException {

        String sql_delete = "DELETE FROM car_service.job WHERE job.jobID = ?";

        if (checkExistingPrimary(deleteData)) {

            PreparedStatement ps = conn.prepareStatement(sql_delete);
            ps.setString(1, deleteData);

            int row = ps.executeUpdate();
            System.out.println(row);

            ps.close();

            long startTime = System.nanoTime();
            int rowCount = 0;

            DatabaseConnection.displayExecutionTime(rowCount, startTime);
        }

        else {
            System.out.println("Query OK, 0 rows affected (0.001 sec)");
        }
    }

    public boolean checkExistingPrimary(String storedData[]) {

        // storedData[0] is the primary id
        String sql_exists = "SELECT EXISTS (SELECT 1 FROM car_service.job WHERE job.jobID = ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql_exists);

            ps.setString(1, storedData[0]);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public boolean checkExistingPrimary(String deleteData) {

        // deleteData is the primary id
        String sql_exists = "SELECT EXISTS (SELECT 1 FROM car_service.job WHERE job.jobID = ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql_exists);

            ps.setString(1, deleteData);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}