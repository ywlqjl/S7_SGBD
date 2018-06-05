
//STEP 1. Import required packages
import java.sql.*;
//import java.util.Scanner; 
import java.util.Scanner;

public class TD1b {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SGBD-TD1b";// ?autoReconnect=true&useSSL=false";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";// my default password is root.
	private static Scanner reader;


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

			
			String Foyers = "CREATE TABLE Foyers " 
					+ "(Code INTEGER not NULL PRIMARY KEY, "
					+ " Pere VARCHAR(255), " 
					+ " Mere VARCHAR(255), " 
					+ " Adresse VARCHAR(55))";
		

			String Citoyen = "CREATE TABLE Citoyen "
					+ "(NSS INTEGER not NULL PRIMARY KEY, "
					+ " Nom VARCHAR(255), " 
					+ " Prenom VARCHAR(255), " 
					+ " Sex VARCHAR(255), " 
					+ " Conjoint2 VARCHAR(255), " 
					+ " Foyer INTEGER not NULL, "
					+ " FOREIGN KEY (Foyer) REFERENCES Foyers(Code) ON DELETE CASCADE ON UPDATE CASCADE)";
			
			int i1 = stmt.executeUpdate(Foyers);
			int i2 = stmt.executeUpdate(Citoyen);


			if (i1 == 0 && i2 == 0 ) {
				System.out.println("Creating tables successfully...");
			}
			
			
			
			
			
			// ========== Insert records ==================================================================================//
			
			reader = new Scanner(System.in);
			System.out.println("Enter the NSS of Citoyen: ");
			int Nss = reader.nextInt(); // Scans the next token of the input as an int.
			
			System.out.println("Enter the FamilyName of Citoyen: ");
			String Nom = reader.next(); 
			
			System.out.println("Enter the FirstName of Citoyen: ");
			String Prenom = reader.next();
			
			System.out.println("Enter the sex of Citoyen: ");
			String Sex = reader.next(); 
			
			System.out.println("Enter the Conjoint of Citoyen: ");
			String Conjoint = reader.next(); 
			
			System.out.println("Enter the number of Foyer of the Citoyen: ");
			int NumFoyer = reader.nextInt(); 
			
			PreparedStatement info = conn.prepareStatement( "INSERT INTO Citoyen VALUES (?, ?, ?, ?, ?, ? );" );
			// Attention: ? ？(English／Chinese)  
			info.setInt(1, Nss);
			info.setString(2,Nom);
			info.setString(3,Prenom);
			info.setString(4,Sex);
			info.setString(5,Conjoint);
			info.setInt(6,NumFoyer);
		
			info.executeUpdate();
			

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
