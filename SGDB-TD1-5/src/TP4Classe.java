
//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TP4Classe {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TP4";// ?autoReconnect=true&useSSL=false";

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

/*			String Livre = "CREATE TABLE Livre " 
					+ "(ISBN INTEGER not NULL PRIMARY KEY, "
					+ " Description VARCHAR(255), " 
					+ " Sujet VARCHAR(255), " 
					+ " NCopie INTEGER(55));";

			String Copie = "CREATE TABLE Copie " 
					+ "(Livre INTEGER not NULL , " 
					+ " Numero VARCHAR(255) not NULL, " 
					+ " CONSTRAINT PK_Livre PRIMARY KEY (Livre, Numero),"
					+ " FOREIGN KEY (Livre) REFERENCES Livre(ISBN))";
			
			String Associes = "CREATE TABLE Associes " 
					+ "(NCarte INTEGER not NULL PRIMARY KEY, "
					+ " Prenom VARCHAR(255), " 
					+ " Nom VARCHAR(255), " 
					+ " Adresse VARCHAR(255), " 
					+ " DateEntree DATE, " 
					+ " NCopieEmprentees INTEGER(55));";
			
			String Emprunts = "CREATE TABLE Enprunts " 
					+ "(Associe INTEGER not NULL,"
					+ " Livre INTEGER not NULL," 
					+ " Copie INTEGER not NULL,"
					+ " EmpruntDate DATE not NULL, "
					+ " CONSTRAINT PK_Emprunts PRIMARY KEY (Associe, Livre, Copie, EmpruntDate ),"
					+ " FOREIGN KEY (Associe) REFERENCES Associes(NCarte),"
					+ " FOREIGN KEY (Livre) REFERENCES Copie(Livre),"
			        + " FOREIGN KEY (Copie) REFERENCES Copie(Livre))";
			
			String Retours = "CREATE TABLE Retours " 
					+ "(Associe INTEGER not NULL,"
					+ " Livre INTEGER not NULL," 
					+ " Copie INTEGER not NULL,"
					+ " RetoursDate DATE, "
					+ " CONSTRAINT PK_Retours PRIMARY KEY ( Associe, Livre, Copie, RetoursDate ),"
					+ " FOREIGN KEY (Associe) REFERENCES Associes(NCarte),"
					+ " FOREIGN KEY (Livre) REFERENCES Copie(Livre),"
			        + " FOREIGN KEY (Copie) REFERENCES Copie(Livre))";		        
			
			String Telephone = "CREATE TABLE Telephone " 
					+ "(Telephone INTEGER not NULL PRIMARY KEY, " 
					+ " Associe VARCHAR(255)); " ;
			
		
			stmt.executeUpdate(Livre);// RETURN 0
			stmt.executeUpdate(Copie);
			stmt.executeUpdate(Associes);
			stmt.executeUpdate(Emprunts);
			stmt.executeUpdate(Retours);
			stmt.executeUpdate(Telephone);

	*/			System.out.println("Creating tables successfully...");
			

			// ================================================================================//
	/*		System.out.println("Inserting records into the table...");
			// reuse the AddData
			String AddData = "INSERT INTO Livre " + " VALUES (001, 'Dubois', 'A', 100) ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO Livre " + " VALUES (002, 'Dupont', 'B', 200) ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO Livre " + " VALUES (010, 'Cuissart', 'C', 150) ";
			 stmt.executeUpdate(AddData);
	*/	
			 
			try{
				String AddData2 = "INSERT INTO Copie " + " VALUES (010, 9) ";
				stmt.executeUpdate(AddData2);			 
				 
			}catch( SQLException se){
			
			}

			 
				
			
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






//<classpathentry kind="lib" path="C:/Users/Administrateur/Downloads/mysql-connector-java-5.1.44/mysql-connector-java-5.1.44/mysql-connector-java-5.1.44-bin.jar"/>
