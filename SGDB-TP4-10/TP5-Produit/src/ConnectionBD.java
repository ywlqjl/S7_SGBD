import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	private static Connection connection = null;
	public static Connection getConnectionObject()
	{
		return connection;
	}
	
	
	public static void init()
	{
		
		
		try
		{
			// Register the driver.
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		
		// Create a connection.
		try
		{
			// Try to open the connection.
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/tp4project", "root", "root");
		}
		catch(SQLException e)
		{
			// SQL error.
			System.out.println("SQL Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
		catch(Exception e)
		{
			// Unknown error.
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	
	
	
	public static void close()
	{
		// Close the connection.
		if(connection != null)
		{
			try
			{
				connection.close();
			}
			catch(Exception e)
			{
				// Unknown error.
				System.out.println("Error: " + e.getMessage());
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
}
