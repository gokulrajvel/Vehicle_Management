import java.sql.*;

public class UserDisplay {
    public UserDisplay() throws SQLException {
        DbConnectivity DbConnection = new DbConnectivity();
        Connection con = DbConnection.getConnection();
        String selectQuery = "SELECT * FROM bike";
        try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
            ResultSet resultSet = selectStatement.executeQuery();

            // Step 3: Process and display the results
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = resultSet.getString(i);

                    System.out.println(columnName + ": " + columnValue);
                }
                System.out.println("-------------------------------");
            }

        }
    }
}
