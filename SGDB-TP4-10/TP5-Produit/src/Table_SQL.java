import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Table_SQL
{

	public static void createTables()
	{
		// Get a connection object.
		Connection connection = ConnectionBD.getConnectionObject();
		
		// Create the table.
		Statement stmt = null;
		try
		{
			stmt = connection.createStatement(); 
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Produit ("
					+ "id VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "typeProduit VARCHAR(255),"
					+ "prix float"
					+ ") ENGINE=InnoDB");
			
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
		finally
		{
			if(stmt != null)
			{
				try
				{
					stmt.close();
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
}
