
//--------------V--------------------
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TP4OperationsV {

	static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TP4";// ?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";// my default password is root.
	private static Scanner reader;
	private static Connection conn;

	
	public static void insertCopie() throws SQLException {//why we throw?
		
		conn = null;
		
		reader = new Scanner(System.in);
		System.out.println("Enter the ISBN: ");
		int CopieISBN = reader.nextInt(); // Scan
		//先判断是否存在这个书，存在，则插入copie，否则报错。
		PreparedStatement chercherLivre = conn.prepareStatement( "SELECT * FROM Livre WHERE ISBN = '?'");
		chercherLivre.setInt(1, CopieISBN);

		
		reader = new Scanner(System.in);
		System.out.println("Enter the Number of Copie: ");
		int CopieNumber = reader.nextInt(); //
		
		PreparedStatement info = conn.prepareStatement( "INSERT INTO Copie VALUES (?, ?);" );
		info.setInt(1, CopieISBN);
		info.setInt(2, CopieNumber);
	
		info.executeUpdate();
		chercherLivre.executeUpdate();
//		stmt.executeUpdate(AddData);
	}
	
//	public static void insertLivre(){
//		select ISBN from Livre where 
//	}
//	
	public static void main(String[] args) {

	//	Connection conn = null;
		Statement stmt = null;

		try {
			
			Class.forName("com.mysql.jdbc.Driver");// find and load the class
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			stmt = conn.createStatement();
			
			insertCopie();

			 
				
			
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

	
	
	
	
}// end TP4OperationsV



