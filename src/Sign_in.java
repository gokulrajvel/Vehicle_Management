import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Sign_in {

    public Sign_in(int n) {
        Scanner sc=new Scanner(System.in);
        if (n == 1) {
            try {
                // Create an instance of DbConnectivity
                DbConnectivity dbConnection = new DbConnectivity();

                // Call the method to establish a connection
                Connection con = dbConnection.getConnection();

//                Statement stmt = con.createStatement();
                System.out.print("Enter Email_id: ");
                String user_id = sc.nextLine();
                System.out.print("Enter your Password: ");
                String password = sc.nextLine();

                // Use a PreparedStatement to prevent SQL injection
                String query = "SELECT * FROM users WHERE user_id = ? AND password = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, user_id);
                    preparedStatement.setString(2, password);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Incorrect Email_id or password.");
                    }
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
            System.out.println("--------------------------------");
        }

    }
}
