package tables;

import database.DatabaseConnection;
import java.sql.*;

public class Garage {

    private Connection conn;

    public Garage() {
        conn = DatabaseConnection.getConnection();
    }

    // METHODS
    public void selectStatement() throws SQLException {

        String sql_select = "SELECT * FROM car_service.garage";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql_select);

        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
        }
    }

    public void insertStatement(String newData) {

        String sql_insert = "INSERT INTO car_service.garage VALUES(?, ?, ?, ?, ?, ?)";

        try {
            String[] storedData = newData.split(",");

            if (storedData.length != 6) {
                System.out.println("Please enter exactly 6 values.");
                return;
            }

            PreparedStatement ps = conn.prepareStatement(sql_insert);

            for (int i = 0; i < storedData.length; i++) {
                ps.setString(i + 1, storedData[i].trim());
            }

            ps.executeUpdate();
            ps.close();

            System.out.println("Garage data successfully added!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatement() {

        String sql_update = "UPDATE car_service.garage SET (?, ?, ?, ?, ?, ?)";

    }

    public void deleteStatement() {

        String sql_delete = "DELETE FROM car_service.garage WHERE garage.userID = ?";

    }
}