import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class RentVehicle {
    public RentVehicle(String user_id) throws SQLException {
        String User=user_id;
        DbConnectivity dbConnection=new DbConnectivity();
        Connection con = dbConnection.getConnection();
        String query = "SELECT * FROM rent_vehicle WHERE User = ?";
        try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
            preparedStatement.setString(1, User);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) { // Check if any vehicles are rented
                // Display vehicle details
                System.out.println("Vehicle Details:");
                do {
                    System.out.println("--------------------");
                    System.out.println("Rent_Bikes: " + resultSet.getString("Rent_Bikes"));
                    System.out.println("Rent_Cars: " + resultSet.getString("Rent_Car"));
                } while (resultSet.next());
            } else {
                System.out.println("User has not rented any vehicles.");
            }
        }
        new UserVisit(user_id);
    }
}
