//STEP 1. Import required packages
import java.sql.*;


public class TP5_1 {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TP5_1";

	static final String USER = "root";
	static final String PASS = "root";

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
			
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Produit ("
					+ "id INTEGER(100) PRIMARY KEY NOT NULL,"
					+ "typeProduit VARCHAR(255),"
					+ "prix float"
					+ ") ENGINE=InnoDB");

			Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = st.executeQuery("SELECT * FROM Produit");
		
			while (rs.next()) {
	            float newPrix = rs.getFloat("prix");
//	            rs.updateFloat(3, (float) (newPrix*1.1));
	            rs.updateFloat("prix", (float) (newPrix*1.1));
	            rs.updateRow();
			}
			

				
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