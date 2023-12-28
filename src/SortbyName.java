import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SortbyName {
    public SortbyName() {
        try {
            DbConnectivity dbConnection = new DbConnectivity();
            Connection con = dbConnection.getConnection();
            String listQuery = "SELECT * FROM bike ORDER BY vehicle_name";
            try (PreparedStatement listStatement = con.prepareStatement(listQuery);
                 ResultSet listResultSet = listStatement.executeQuery()) {
                while (listResultSet.next()) {
                    String bikeName = listResultSet.getString("vehicle_name");
                    System.out.println("vehicle Name: " + bikeName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}