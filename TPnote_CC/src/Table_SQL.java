import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Table_SQL
{
	/**
	 * Creates the SQL tables in the database.
	 */
	public static void createTables()
	{
		// Get a connection object.
		Connection connection = ConnectionDAO.getConnectionObject();
		
		// Create the table.
		Statement stmt = null;
		try
		{
			stmt = connection.createStatement(); 
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Utilisateur ("
					+ "idUtilisateur INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,"
					+ "Nom VARCHAR(255),"
					+ "Prenom VARCHAR(255),"
					+ "Email VARCHAR(255),"
					+ "Motdepasse VARCHAR(255),"
					+ ") ");
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Annonce ("
					+ "idAnnonce INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
					+ "Titre VARCHAR(255),"
					+ "TransactionType VARCHAR(100),"
					+ "Position VARCHAR(255),"
					+ "Categorie VARCHAR(255),"
					+ "Prix VARCHAR(100),"
					+ "Description VARCHAR(255),"
					+ "idUtilisateur INT,"
					+ "FOREIGN KEY (idUtilisateur) REFERENCES Utilisateur(idUtilisateur)"
					+ ") ");
			
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
