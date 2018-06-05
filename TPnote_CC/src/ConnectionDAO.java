import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDAO
{
	/***
	 * The connection object.
	 */
	private static Connection connection = null;
	
	/**
	 * Returns the connection object.
	 * init() must have been called before.
	 * 
	 * @returns the connection object
	 */
	public static Connection getConnectionObject()
	{
		return connection;
	}

	/**
	 * Init the connection to the database.
	 * Load the driver and create a connection object.
	 */
	public static void init()
	{
		// Load the driver.
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
	
	/**
	 * Closes the connection to the database.
	 */
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
