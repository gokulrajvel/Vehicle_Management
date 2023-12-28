import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Admin {

    public Admin(int n){
        Scanner sc=new Scanner(System.in);
        if(n==3){
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
                String query = "SELECT * FROM admin WHERE Email_id = ? AND password = ?";
                try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                    preparedStatement.setString(1, user_id);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        System.out.println("Login successful!");
                        System.out.println("--------------------------------");
                        AdminVist av= new AdminVist();

                    } else {
                        System.out.println("Incorrect Email_id or password.");
                        System.out.println("--------------------------------");
                        req Req=new req();
                    }
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
            System.out.println("--------------------------------");
        }
    }
}
