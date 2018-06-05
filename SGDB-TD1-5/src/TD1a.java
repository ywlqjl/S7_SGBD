
//STEP 1. Import required packages
import java.sql.*;
//import java.util.Scanner; 

public class TD1a {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SGBD-TD1a";// ?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";// my default password is root.

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");// find and load the class

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// ================================================================================//
			// STEP 4: Execute a query
			System.out.println("Creating tables in given database...");
			stmt = conn.createStatement();

			String Fournisseurs = "CREATE TABLE Fournisseurs " 
					+ "(CodeFournisseur INTEGER not NULL PRIMARY KEY, "
					+ " Nom VARCHAR(255), " 
					+ " Adresses VARCHAR(255), " 
					+ " Ville VARCHAR(55));";
			// + " PRIMARY KEY ( CodeFournisseur ));";

			String Produits = "CREATE TABLE Produits " 
					+ "(CodeProduit INTEGER not NULL, " 
					+ " Type VARCHAR(255), "
					+ " Marque VARCHAR(255), " 
					+ " Modele VARCHAR(55), " 
					+ " PRIMARY KEY ( CodeProduit ));";

			String Catalogue = "CREATE TABLE Catalogue " 
					+ "(Fournisseur INTEGER not NULL, "
					+ " Produit INTEGER not NULL," 
					+ " Prix FLOAT, "
					+ " CONSTRAINT PK_Catalogue PRIMARY KEY ( Fournisseur, Produit ),"
					+ " FOREIGN KEY (Fournisseur) REFERENCES Fournisseurs (CodeFournisseur)  ON DELETE CASCADE,"
					+ " FOREIGN KEY (Produit) REFERENCES Produits (CodeProduit) ON DELETE CASCADE )";

			int i1 = stmt.executeUpdate(Fournisseurs);// RETURN 0
			int i2 = stmt.executeUpdate(Produits);
			int i3 = stmt.executeUpdate(Catalogue);

			if (i1 == 0 && i2 == 0 && i3 == 0) {
				System.out.println("Creating tables successfully...");
			}

			// ====== Insert records into database ===================================================//

			System.out.println("Inserting records into the table...");
			// reuse the AddData
			
			String AddData = "INSERT INTO Fournisseurs " + " VALUES (002, 'Dupont', 'Avenue Generale De Gaule', 'Paris') ";
			int j2 = stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO Fournisseurs " + " VALUES (001, 'Dubois', 'Rue Paul Bert', 'Toulouse') ";
			int j1 = stmt.executeUpdate(AddData);

			AddData = "INSERT INTO Fournisseurs " + " VALUES (010, 'Cuissart', 'Rue Vaugirard', 'Lyon') ";
			int j3 = stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO Produits " + " VALUES (11111, 'Jouet', 'JACADI', 'Petit') ";
			int j4 = stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO Catalogue " + " VALUES (010, 11111, 22.05) ";
			int j5 = stmt.executeUpdate(AddData);


			if (j1 == 0 && j2 == 0 && j3 == 0 && j4 == 0 & j5 == 0) {
				System.out.println("Insert data successfully...");
			}

			
			// ==== Delete a table from database =====================================================================//
			System.out.println("Delete records from the table...");
			String SupprimerData = "DELETE FROM Fournisseurs WHERE Nom ='Cuissart' ";
			int suppression = stmt.executeUpdate(SupprimerData);
			
			if (suppression == 0) {
				System.out.println("Delete records successfully...");
			}
			
			
			/////////why we cannot delete the record in table Produits ?
			
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				// do nothing
			}

			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		System.out.println("Goodbye!");
	}// end main

}// end TD1
