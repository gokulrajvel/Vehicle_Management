import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchVehicleByName {
    public SearchVehicleByName() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the vehicle Name: ");
        String searchName=sc.nextLine();
        try {
            DbConnectivity dbConnection = new DbConnectivity();
            Connection con = dbConnection.getConnection();
            String searchQuery = "SELECT * FROM bike WHERE vehicle_name = ?";
            try (PreparedStatement searchStatement = con.prepareStatement(searchQuery)) {
                searchStatement.setString(1, searchName);

                try (ResultSet searchResultSet = searchStatement.executeQuery()) {
                    if (searchResultSet.next()) {
                        String vehicleName = searchResultSet.getString("vehicle_name");
                        String numberPlate = searchResultSet.getString("numberplate");
                        int availableNumber = searchResultSet.getInt("available_number");
                        int securityDeposit = searchResultSet.getInt("security_deposit_amount");

                        System.out.println("Vehicle Name: " + vehicleName);
                        System.out.println("Number Plate: " + numberPlate);
                        System.out.println("Available Number: " + availableNumber);
                        System.out.println("Security Deposit: " + securityDeposit);
                    } else {
                        System.out.println("Vehicle with name " + searchName + " not found.");
                    }
                }
            }
            new AdminVist();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
