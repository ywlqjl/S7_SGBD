import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LivreDAO
{
	/**
	 * Returns the data of the book.
	 * 
	 * @param ISBN the ISBN to look for
	 * @return an object containing the data
	 */
	public static Livre getLivreByISBN(String ISBN)
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
	
	public static boolean addLivre(String ISBN, String description, String Sujet) 
	{
		
		// Get a connection.
		Connection connection = ConnectionDAO.getConnectionObject();
		
		try
		{
			// Prepare a statement.
			PreparedStatement stmt = (PreparedStatement)connection.prepareStatement("SELECT * FROM Livre WHERE ISBN = ?");
			stmt.setString(1, ISBN);
			ResultSet rs = stmt.executeQuery();
			int nbcopies = 0; 
			
			// Check for the first book found.
			if(!rs.first())
			{
				//ADD the book to the table livre
				stmt = connection.prepareStatement("INSERT INTO Livre (ISBN, Description, Sujet, NCopies) VALUES(?,?,?,?)");
				stmt.setString(1, ISBN);
				stmt.setString(2, description);
				stmt.setString(3, Sujet);
				stmt.setInt(4, nbcopies);
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
		System.out.println("Le livre existe deja.");
		return false;
		
	}
}
