import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SortByAvailableNumber {
    public SortByAvailableNumber() {
        try {
            DbConnectivity dbConnection = new DbConnectivity();
            Connection con = dbConnection.getConnection();
            String listQuery = "SELECT vehicle_name, available_number FROM bike ORDER BY available_number";
            try (PreparedStatement listStatement = con.prepareStatement(listQuery);
                 ResultSet listResultSet = listStatement.executeQuery()) {

                while (listResultSet.next()) {
                    String vehicleName = listResultSet.getString("vehicle_name");
                    String availableNumber = listResultSet.getString("available_number");
                    System.out.println("Vehicle Name: " + vehicleName + ", Available Number: " + availableNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
