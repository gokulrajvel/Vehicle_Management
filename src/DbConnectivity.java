import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectivity {
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/project",
                "root",
                "mrdio2");
    }
}
