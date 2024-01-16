import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class DepositAmount {
    public DepositAmount(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter borrower ID: ");
        String borrowerId = sc.next();

        System.out.print("Enter new security deposit amount: ");
        int newDepositAmount = sc.nextInt();
        try {
            DbConnectivity dbConnection = new DbConnectivity();
            Connection con = dbConnection.getConnection();
            String updateQuery = "UPDATE bike SET security_deposit_amount = ? WHERE Serial_no = ?";

            try (PreparedStatement updateStatement = con.prepareStatement(updateQuery)) {
                updateStatement.setInt(1, newDepositAmount);
                updateStatement.setString(2, borrowerId);

                int rowsAffected = updateStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Security deposit updated successfully for borrower " + borrowerId);
                } else {
                    System.out.println("Borrower with ID " + borrowerId + " not found. Security deposit not updated.");
                }
                new AdminVist();
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
