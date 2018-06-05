//STEP 1. Import required packages
import java.sql.*;
//import java.util.Scanner; 


public class TD3a {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TD3a?autoReconnect=true&useSSL=false&AllowMultiQueries=yes"; //AllowMultiQueries=yes

	static final String USER = "root";
	static final String PASS = "root";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating tables in given database...");
			stmt = conn.createStatement();

			String Auteurs = "CREATE TABLE Auteurs "
					+ "(Code INTEGER not NULL, "
					+ " Nom VARCHAR(255), " 
					+ " Prenom VARCHAR(255)," 
					+ " PRIMARY KEY ( Code))";

			String Editeur = "CREATE TABLE Editeur "
					+ "(Code INTEGER not NULL, "
					+ " Nom VARCHAR(255), " 
					+ " Adresse VARCHAR(255), "
					+ " Ville VARCHAR(55), "
					+ " PRIMARY KEY ( Code ));";

			String Livre = "CREATE TABLE Livre "
					+ "(ISBN INTEGER not NULL PRIMARY KEY, "
					+ " Titre VARCHAR(255), " 
					+ " URLImage VARCHAR(255), "
					+ " Auteur INTEGER not NULL, " 
					+ " Editeur INTEGER not NULL, "
					+ " FOREIGN KEY (Auteur) REFERENCES Auteurs(Code) ON DELETE CASCADE ON UPDATE CASCADE,"
					+ " FOREIGN KEY (Editeur) REFERENCES Editeur(Code) ON DELETE CASCADE ON UPDATE CASCADE)";
			
			stmt.executeUpdate(Editeur);
			stmt.executeUpdate(Auteurs);
			stmt.executeUpdate(Livre);
			
			

// =========== Insert records into the table =====================================================================//

			System.out.println("Inserting records into the table...");
			// reuse AddData
			String AddData = "INSERT INTO Auteurs " + " VALUES (001, 'Apple', 'aaa') ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO Auteurs " + " VALUES (002, 'Banana', 'bbb') ";
			stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO Auteurs " + " VALUES (003, 'Orange', 'ooo') ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO Editeur " + " VALUES (211, 'Meimei', 'Rue Kabab', 'Paris') ";
			stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO Editeur " + " VALUES (312, 'Youyou', 'Rue Fromage', 'Lyon') ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO Livre " + " VALUES (1000234, 'I am happy to meet you', 'http234', 003, 312) ";
			stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO Livre " + " VALUES (1011235, 'Can you give me a smile', 'http235', 002, 211) ";
			stmt.executeUpdate(AddData);

			
			System.out.println("Insert data successfully...");
			
		/*	
				ResultSet listeLivre = stmt.executeQuery("SELECT Titre, Auteurs.Nom AS NomA , Auteurs.Prenom AS PrenomA,"
						+ " Editeur.Nom AS NomE, Editeur.Ville AS VilleE FROM Livre LEFT JOIN Auteurs ON Livre.Auteur = Auteurs.Code"
						+ " LEFT JOIN Editeur ON Livre.Editeur = Editeur.Code");
				
				while (listeLivre.next()) {
		            String Titre = listeLivre.getString("Titre");
		            String NomA = listeLivre.getString("NomA");
		            String PrenomA = listeLivre.getString("PrenomA");
		            String NomE = listeLivre.getString("NomE");
		            String VilleE = listeLivre.getString("VilleE");
		            System.out.println(Titre + "\t\t\t" + NomA +
		                               "\t\t\t" + PrenomA + "\t\t\t" + NomE +
		                               "\t\t\t" + VilleE);	  
				}
				*/
			
//-------------------------------------- PreparedStatement ----------------------------------------------------------------------
/*				Scanner reader = new Scanner(System.in);  // Reading from System.in
				System.out.println("Enter a ISBN: ");
				int n = reader.nextInt(); // Scans the next token of the input as an int.

			
				PreparedStatement infoISBN = conn.prepareStatement("SELECT Titre, Auteur.Nom, Auteur.Prenom, Editeur.Nom, URLImage"
						+ " FROM Livre LEFT JOIN Auteur ON Livre.Auteur = Auteur.Code "
						+ "LEFT JOIN Editeur ON Livre.Editeur = Editeur.Code WHERE ISBN = ?");
				
				infoISBN.setInt(1, n);
				ResultSet rs = infoISBN.executeQuery();
				
				while (rs.next()) {
		            String Titre = rs.getString("Titre");
		            String NomA = rs.getString("Auteur.Nom");
		            String PrenomA = rs.getString("Auteur.Prenom");
		            String NomE = rs.getString("Editeur.Nom");
		            String URLImage = rs.getString("URLImage");
		            System.out.println(Titre+ "\t\t" + NomA +
                            "\t\t" + PrenomA + "\t\t" + NomE +
                            "\t\t" + URLImage);	  
				}

*/
			
//-------------------------------------- Statement --------------------------------------------------------------------------
/*
			Statement statement = null;
			
			String query = "SELECT Titre, Auteur.Nom, Auteur.Prenom, Editeur.Nom, URLImage"
					+ " FROM Livre LEFT JOIN Auteur ON Livre.Auteur = Auteur.Code "
					+ " LEFT JOIN Editeur ON Livre.Editeur = Editeur.Code WHERE ISBN = 51 OR 1=1";

			
			statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
	            String Titre = rs.getString("Titre");
	            String NomA = rs.getString("Auteur.Nom");
	            String PrenomA = rs.getString("Auteur.Prenom");
	            String NomE = rs.getString("Editeur.Nom");
	            String URLImage = rs.getString("URLImage");
	            System.out.println(Titre+ "\t\t" + NomA +
                        "\t\t" + PrenomA + "\t\t" + NomE +
                        "\t\t" + URLImage);	  
			
			}
					
			String inj = "DROP TABLE utilisateurs";
			statement.executeQuery(inj);
			
			
	*/		
			
			System.out.println("Created tables in given database...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			}// do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main
}// end JDBCExample