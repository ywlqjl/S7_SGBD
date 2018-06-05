import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UtilisateurDAO
{
	/**
	 * Returns the data of the book.
	 * 
	 * @param ISBN the ISBN to look for
	 * @return an object containing the data
	 */
	/*public static Utilisateur getLivreByISBN(String ISBN)
	{
		// Get a connection.
		Connection connection = ConnectionDAO.getConnectionObject();
		
		try
		{
			// Prepare a statement.
			PreparedStatement stmt = (PreparedStatement)connection.prepareStatement("SELECT * FROM Livre WHERE ISBN = ?");
			stmt.setString(1, ISBN);
			ResultSet rs = stmt.executeQuery();
			
			// Check for the first book found.
			if(rs.first())
			{
				return new Livre(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
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

		// Error.
		System.out.println("Aucune livre avec ce ISBN n'a ete trouve.");
		return null;
	}
	*/
	public static boolean addUtilisateur(int idUtilisateur, String Nom, String Prenom, String Email, String Motdepasse) 
	{
		
		// Get a connection.
		Connection connection = ConnectionDAO.getConnectionObject();
		
		try
		{
			// Prepare a statement.
			PreparedStatement stmt = (PreparedStatement)connection.prepareStatement("SELECT * FROM Utilisateur WHERE idUtilisateur = ?");
			stmt.setInt(1, idUtilisateur);
			ResultSet rs = stmt.executeQuery();
			
			// Check for the first Utilisateur found. If null, the Utilisateur doesn't exist in the database.So we add it.
			if(!rs.first())
			{
				//ADD the Utilisateur to the table Utilisateur
				stmt = connection.prepareStatement("INSERT INTO Utilisateur (idUtilisateur, Nom, Prenom, Email, Motdepasse) VALUES(?,?,?,?,?)");
				stmt.setInt(1, idUtilisateur);
				stmt.setString(2, Nom);
				stmt.setString(3, Prenom);
				stmt.setString(4, Email);
				stmt.setString(5, Motdepasse);
				stmt.executeUpdate();
				return true;
			}
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
		
		// Error.
		System.out.println("Le Utilisateur existe deja.");
		return false;
		
	}
}
