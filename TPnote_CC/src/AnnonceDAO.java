import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class AnnonceDAO
{
	/**
	 * @param ISBN
	 * @return 
	 * @return all the copies of the book
	 */
//	public static Annonce getAnnonceById (int idAnnonce)
//	{
//		// Get a connection.
//				Connection connection = ConnectionDAO.getConnectionObject();
//				
//				try
//				{
//					// Prepare a statement.
//					PreparedStatement stmt = (PreparedStatement)connection.prepareStatement("SELECT * FROM Annonce WHERE idAnnonce = ?");
//					stmt.setInt(1, idAnnonce);
//					ResultSet rs = stmt.executeQuery();
//					
//					// Check for the first book found.
//					if(rs.first())
//					{
//						return new Annonce(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getInt(1));
////						while (rs.next()) {
////							int idA = rs.getInt("idAnnonce");
////				            String Titre = rs.getString("Titre");
////				            String TransactionType = rs.getString("TransactionType");
////				            String Position = rs.getString("Position");
////				            String Categorie = rs.getString("Categorie");
////				            String Prix = rs.getString("Prix");
////				            String Description = rs.getString("Description");
////				            int idUtilisateur = rs.getInt("idUtilisateur");
//////				            System.out.println(Titre + "\t\t\t" + NomA +
//////				                               "\t\t\t" + PrenomA + "\t\t\t" + NomE +
//////				                               "\t\t\t" + VilleE);	  
////						}
//					}
//				}
//				catch(SQLException e)
//				{
//					// SQL error.
//					System.out.println("SQL Error: " + e.getMessage());
//					e.printStackTrace();
//					System.exit(1);
//				}
//				catch(Exception e)
//				{
//					// Unknown error.
//					System.out.println("Error: " + e.getMessage());
//					e.printStackTrace();
//					System.exit(1);
//				}
//
//				// Error.
//				System.out.println("Aucune livre avec ce ISBN n'a ete trouve.");
//				return null;
//	}
	
	public static boolean IfExistAnnonce(int idAnnonce)
	{
		try
		{
			Connection connection = ConnectionDAO.getConnectionObject();
			PreparedStatement stmt = (PreparedStatement)connection.prepareStatement("SELECT * FROM Annonce WHERE idAnnonce = ?");
			stmt.setInt(1, idAnnonce);
			ResultSet rs = stmt.executeQuery();
			if(rs!=null) return true;
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
		return false;
	
	}
	

	
	public static boolean addAnnonce(int idAnnonce, String Titre, String TransactionType, String Position,String Categorie,String Prix,String Description,Integer idUtilisateur )
	{
		// Get the book.
//		ifIfExistAnnonce(idAnnonce);
		
		// Check if the book has been found.
		if(IfExistAnnonce(idAnnonce) == false)
		{
			
			try
			{
				Connection connection = ConnectionDAO.getConnectionObject();
				
				// Add a new copy.
				PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Annonce(int idAnnonce, String Titre, String TransactionType, String Position,String Categorie,String Prix,String Description,Integer idUtilisateur ) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
				pstmt.setInt(1, idAnnonce);
				pstmt.setString(2, Titre);
				pstmt.setString(3, TransactionType);	
				pstmt.setString(4, Position);
				pstmt.setString(5, Categorie);
				pstmt.setString(6, Prix);
				pstmt.setString(7, Description);
				pstmt.setInt(2, idUtilisateur);
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
