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
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Livre ("
					+ "ISBN VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "Description VARCHAR(255),"
					+ "Sujet VARCHAR(255),"
					+ "NCopies INT"
					+ ") ENGINE=InnoDB");
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Copie ("
					+ "IdCopie INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
					+ "Livre VARCHAR(100),"
					+ "Numero INT,"
					+ "FOREIGN KEY (Livre) REFERENCES Livre(ISBN)"
					+ ") ENGINE=InnoDB");
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Associes ("
					+ "NCarte VARCHAR(100) PRIMARY KEY NOT NULL,"
					+ "Prenom VARCHAR(255),"
					+ "Nom VARCHAR(255),"
					+ "Adresse VARCHAR(255),"
					+ "DateEntree DATE,"
					+ "NbCopiesEmpruntees INT"
					+ ") ENGINE=InnoDB");
		
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Telephone ("
					+ "Telephone VARCHAR(10) PRIMARY KEY NOT NULL,"
					+ "Associe VARCHAR(100),"
					+ "FOREIGN KEY (Associe) REFERENCES Associes(NCarte)"
					+ ") ENGINE=InnoDB");
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Emprunts ("
					+ "Associe VARCHAR(100),"
					+ "Livre VARCHAR(100),"
					+ "Copie INT,"
					+ "Date DATE,"
					+ "PRIMARY KEY(Associe, Livre, Copie, Date),"
					+ "FOREIGN KEY (Associe) REFERENCES Associes(NCarte),"
					+ "FOREIGN KEY (Livre) REFERENCES Livre(ISBN),"
					+ "FOREIGN KEY (Copie) REFERENCES Copie(IdCopie)"
					+ ") ENGINE=InnoDB");
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Retours ("
					+ "Associe VARCHAR(100),"
					+ "Livre VARCHAR(100),"
					+ "Copie INT,"
					+ "Date DATE,"
					+ "PRIMARY KEY(Associe, Livre, Copie, Date),"
					+ "FOREIGN KEY (Associe) REFERENCES Associes(NCarte),"
					+ "FOREIGN KEY (Livre) REFERENCES Livre(ISBN),"
					+ "FOREIGN KEY (Copie) REFERENCES Copie(IdCopie)"
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
