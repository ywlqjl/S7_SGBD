import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


public class CopieDAO
{
	/**
	 * @param ISBN
	 * @return all the copies of the book
	 */
	public static List<Copie> getCopiesOfBook(String ISBN)
	{
		// Get the book.
		Livre book = LivreDAO.getLivreByISBN(ISBN);
		
		// Check if the book has been found.
		if(book != null)
		{
			List<Copie> copies = new ArrayList<Copie>();
			
			// Get a connection.
			try
			{
				Connection connection = ConnectionDAO.getConnectionObject();
				
				PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM Copie WHERE Livre = ?");
				pstmt.setString(1, ISBN);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.first())
				{
					do
					{
						copies.add(new Copie(book, rs.getInt(2)));//and one record to the Arrayliste
					} while(rs.next());
					
					return copies;// return the whole arrayliste
				}
				else
				{
					return null;
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
			
			return null;
		}
		else
		{
			// Error.
			// No book => no copy.
			return null;
		}
	}
	
	/**
	 * Adds a copy of the book.
	 * @param ISBN the isbn of the book
	 * @return true if the insertion succeded
	 */
	public static boolean addCopyOfBook(String ISBN)
	{
		// Get the book.
		Livre book = LivreDAO.getLivreByISBN(ISBN);
		
		// Check if the book has been found.
		if(book != null)
		{
			List<Copie> copies = getCopiesOfBook(ISBN);
			int copyNumber = 1;
			
			if(copies == null || copies.size() == 0)
			{
				// No copies found.
			}
			else
			{
				copyNumber = copies.size() + 1;
			}
			
			try
			{
				Connection connection = ConnectionDAO.getConnectionObject();
				
				// Add a new copy.
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Copie(Livre, Numero) VALUES(?, ?)");
				pstmt.setString(1, ISBN);
				pstmt.setInt(2, copyNumber);
				pstmt.executeUpdate();
				
				// Increment the number of copies.
				pstmt = connection.prepareStatement("UPDATE Livre SET NCopies = ? WHERE ISBN = ?");
				pstmt.setInt(1, book.getNCopies() + 1);
				pstmt.setString(2, ISBN);
				pstmt.executeUpdate();
				
				return true;
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
		else
		{
			// Error.
		}
		
		return false;
	}
}
