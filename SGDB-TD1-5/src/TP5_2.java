//STEP 1. Import required packages
import java.sql.*;
import java.util.Scanner;


public class TP5_2 {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TP5_1";

	static final String USER = "root";
	static final String PASS = "root";
	private static Scanner reader;

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {

			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating tables in given database...");
			stmt = conn.createStatement();
			
			
			reader = new Scanner(System.in);
			System.out.println("Inserer id de ce produit: ");
			int param1 = reader.nextInt();
			
			System.out.println("Inserer type de ce produit: ");
			String param2 = reader.next();
			
			System.out.println("Inserer prix de ce produit: ");
			float param3 = reader.nextFloat();

			
// facon1: statement 
//			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs = st.executeQuery("INSERT INTO Produit " + " VALUES ('?', '?', '?')");

//facon2: prepareStatement   		
			String sql = "INSERT INTO Produit VALUES (?, ?, ?)";
			PreparedStatement pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			pst.setInt(1, param1);
			pst.setString(2, param2);
			pst.setFloat(3, param3);

			pst.executeUpdate();
		
		
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