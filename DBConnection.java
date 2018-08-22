import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to make connection with the database 
 * @author Richa Jain
 *
 */
public class DBConnection {

	private static final String database_name = "storefront";
	private static final String url = "jdbc:mysql://localhost:3306/" + database_name;
	private static final String username = "root";
	private static final String password = "user#123";

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return conn;
	}
	
}
