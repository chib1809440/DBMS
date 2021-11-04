import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect_MySQL {
    private static final String hostName = "localhost";
    private static final String dbName = "project_dbms";
    private static final String userName = "root";
    private static final String password = "ichiu1999";
    // jdbc:mysql://hostname:port/dbname
    private static final String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
 
    public static Connection openConnection() throws SQLException {
        // 1. Load Driver
        // Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
 
        // 2. Open connection
        return DriverManager.getConnection(connectionURL, userName, password);
    }
   
}
