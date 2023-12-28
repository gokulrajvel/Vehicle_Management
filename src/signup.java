import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class signup {

    public signup(int n) {
        Scanner sc = new Scanner(System.in);
        if (n == 2) {
            try {
                DbConnectivity dbConnection = new DbConnectivity();
                Connection con = dbConnection.getConnection();
                System.out.print("Enter the Mail_id: ");
                String user_id = sc.next();
                System.out.print("Enter the password: ");
                String password = sc.next();
                // Step 1: Check if the user already exists (SELECT operation)
                String selectQuery = "SELECT * FROM users WHERE user_id = ?";
                try (PreparedStatement selectStatement = con.prepareStatement(selectQuery)) {
                    selectStatement.setString(1, user_id);
                    ResultSet resultSet = selectStatement.executeQuery();

                    if (resultSet.next()) {
                        // User already exists, handle accordingly (e.g., display an error message)
                        System.out.println("User already exists. Registration failed!");
                    } else {
                        // User doesn't exist, proceed with registration (INSERT operation)
                        String insertQuery = "INSERT INTO users (user_id, password) VALUES (?, ?)";
                        try (PreparedStatement insertStatement = con.prepareStatement(insertQuery)) {
                            insertStatement.setString(1, user_id);
                            insertStatement.setString(2, password);

                            int rowsAffected = insertStatement.executeUpdate();

                            if (rowsAffected > 0) {
                                System.out.println("\tRegistration successful!");
                                req r=new req();
                            } else {
                                System.out.println("\tRegistration failed");
                                req r=new req();
                            }
                        }
                    }
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
            System.out.println("--------------------------------");
        }
    }
}