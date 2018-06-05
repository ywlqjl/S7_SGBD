//STEP 1. Import required packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 


public class TD3b {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TD3b";

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

	/*		String Pays = "CREATE TABLE Pays "
					+ "(NomPay VARCHAR(255) not NULL PRIMARY KEY)";
			
			String Chanteurs = "CREATE TABLE Chanteurs "
					+ "(NomC VARCHAR(255) not NULL PRIMARY KEY , "
					+ " Pays VARCHAR(255), "
					+ " FOREIGN KEY (Pays) REFERENCES Pays(NomPay) ON DELETE SET NULL  ON UPDATE CASCADE)";


			String Producteurs = "CREATE TABLE Producteurs "
					+ "(NomP VARCHAR(255) not NULL PRIMARY KEY, "
					+ " Adresse VARCHAR(255), "
					+ " Pays VARCHAR(255),"
					+ " FOREIGN KEY (Pays) REFERENCES Pays(NomPay) ON DELETE SET NULL  ON UPDATE CASCADE)";
			

			String Album = "CREATE TABLE Album "
					+ "(idAlbum INTEGER not NULL PRIMARY KEY, "
					+ " Titre VARCHAR(255), " 
					+ " Annee VARCHAR(255), "
					+ " Produteur VARCHAR(255), " 
					+ " Prix INTEGER, "
					+ " Chanteur VARCHAR(255), " 
					+ " FOREIGN KEY (Producteur) REFERENCES Producteurs(NomP) ON DELETE SET NULL ON UPDATE CASCADE,"
					+ " FOREIGN KEY (Chanteur) REFERENCES Chanteurs(NomC) ON DELETE SET NULL ON UPDATE CASCADE)";
			
			String Chanson = "CREATE TABLE Chanson "
					+ "(Titre VARCHAR(255) not NULL PRIMARY KEY, "
					+ " Album INTEGER, "
					+ " Position INTEGER,"
					+ " Duree VARCHAR(255),"
					+ " FOREIGN KEY (Album) REFERENCES Album(idAlbum) ON DELETE CASCADE  ON UPDATE CASCADE)";
		
			stmt.executeUpdate(Pays);
			stmt.executeUpdate(Chanteurs);
			stmt.executeUpdate(Producteurs);
			stmt.executeUpdate(Album);
			stmt.executeUpdate(Chanson);
			
		*/	
/*
			
// =========== 1. Afficher les albums : chanteurs francais produit && producteurs francais ============================//
/*	
			String sql = "SELECT idAlbum, Titre, Annee, Produteur,Produteurs.Pays, Prix, Chanteur, Chanteurs.Pays"//// can we use * for showing all the informations?
					+ " FROM Album INNER JOIN Chanteurs ON Album.Chanteur = Chanteurs.NomC"
					+ " INNER JOIN Produteurs ON Album.Produteur = Produteurs.NomP"
					+ " WHERE Produteurs.Pays = 'France' AND Chanteurs.Pays = 'France'" ;
			ResultSet infoAlbum = stmt.executeQuery(sql);
			
			while (infoAlbum.next()) {
	            String Titre = infoAlbum.getString("Titre");
	            String Annee = infoAlbum.getString("Annee");
	            String Producteur = infoAlbum.getString("Produteur");
              String ProPay = infoAlbum.getString("Produteurs.Pays");
	            String Prix = infoAlbum.getString("Prix");
	            String Chanteur = infoAlbum.getString("Chanteur");
	            String ChanPay = infoAlbum.getString("Chanteurs.Pays");
			
	            System.out.println(Titre + "\t\t" + Annee +"\t\t" + Producteur + "\t\t" + ProPay + "\t\t" + Prix +"\t\t" + Chanteur +"\t\t" + ChanPay);	  
			}
*/			
			
// =========== 2. Afficher les albums : chanteurs Pay == producteurs Pay -- meme nationalite =====================================================================//
/*				
			String sql = "SELECT idAlbum, Titre, Annee, Produteur,Produteurs.Pays, Prix, Chanteur, Chanteurs.Pays"//// can we use * for showing all the informations?
			+ " FROM Album INNER JOIN Chanteurs ON Album.Chanteur = Chanteurs.NomC"
			+ " INNER JOIN Produteurs ON Album.Produteur = Produteurs.NomP"
			+ " WHERE Produteurs.Pays = Chanteurs.Pays " ;
			
	ResultSet infoAlbum = stmt.executeQuery(sql);
	
	while (infoAlbum.next()) {
        String Titre = infoAlbum.getString("Titre");
        String Annee = infoAlbum.getString("Annee");
        String Produteur = infoAlbum.getString("Produteur");
        String ProPay = infoAlbum.getString("Produteurs.Pays");
        String Prix = infoAlbum.getString("Prix");
        String Chanteur = infoAlbum.getString("Chanteur");
        String ChanPay = infoAlbum.getString("Chanteurs.Pays");
	
        System.out.println(Titre + "\t\t" + Annee +"\t\t" + Produteur + "\t\t" + ProPay + "\t\t" + Prix +"\t\t" + Chanteur +"\t\t" + ChanPay);	  
	}*/

			
// =========== 4. Afficher la valeur totale des albums des chanteurs d'un meme pays =========================================//

	/*		
			String sql = "SELECT Chanteurs.Pays, count(idAlbum) AS Totale"//// can we use * for showing all the informations?
				+ " FROM Album INNER JOIN Chanteurs ON Album.Chanteur = Chanteurs.NomC"
				+ " INNER JOIN Produteurs ON Album.Produteur = Produteurs.NomP"
	  			+ " WHERE Produteurs.Pays = Chanteurs.Pays " 
				+ " Group by Chanteurs.Pays ";
			
			ResultSet infoAlbum = stmt.executeQuery(sql);
			
			while (infoAlbum.next()) {
	            
	            String Totale = infoAlbum.getString("Totale");
	            String ChanPay = infoAlbum.getString("Chanteurs.Pays");
			
	            System.out.println( ChanPay + "\t" + Totale );	  
			}
	*/

// =========== 5. Afficher le nom du chanteur qui interprete la chanson plus longue =========================================//
			
	/*		String sql = "SELECT Album.Chanteur, Chanson.Titre, Max(Duree) AS MaxDuree"//// can we use * for showing all the informations?
				+ " FROM Chanson INNER JOIN Album ON Album.idAlbum = Chanson.Album";
			
			ResultSet infoAlbum = stmt.executeQuery(sql);
			
			while (infoAlbum.next()) {
	            
	            String AlbumChanteur = infoAlbum.getString("Album.Chanteur");
	            String ChansonTitre = infoAlbum.getString("Chanson.Titre");
	            String MaxDuree = infoAlbum.getString("MaxDuree");
			
	            System.out.println( AlbumChanteur + "\t" + ChansonTitre + "\t" + MaxDuree );	  
			}
	 */
			
// =========== 6. Afficher le nom de l'album plus long en duree totale =========================================//
			
			String sql = "SELECT Album.Titre, SUM(Duree) As TotalDuree "
					+ "FROM Chanson JOIN Album ON Album.idAlbum = Chanson.Album "
					+ "GROUP BY Album.Titre "
					+ "ORDER BY TotalDuree DESC  limit 1;";

			ResultSet infoAlbum = stmt.executeQuery(sql);
			
			while (infoAlbum.next()) {
	            
	            String AlbumTitre = infoAlbum.getString("Album.Titre");
	            String MaxDuree = infoAlbum.getString("TotalDuree");
	            
			
	            System.out.println( " l'album plus long en duree totale est: "+"\t"+ AlbumTitre + "\t" + MaxDuree );	  
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