//STEP 1. Import required packages
import java.sql.*;


public class TP5_3 {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TP4";

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

			
			 //DatabaseMetaData实例的获取  
            DatabaseMetaData metaData = conn.getMetaData();  
            //获取数据库的名字  
            System.out.println("获取数据库的名字:"+metaData.getDatabaseProductName());  
            //获取数据库的版本  
            System.out.println("获取数据库的版本:"+metaData.getDatabaseProductVersion());  
            //获取数据库的主版本  
            System.out.println("获取数据库的主版本:"+metaData.getDatabaseMajorVersion());  
            //获取数据库的小版本  
            System.out.println("获取数据库的小版本:"+metaData.getDatabaseMinorVersion()); 
      
            //get the informations of table
            //metaData.getTables(catalog, schema, tableName, types);  
            //rs=metaData.getTables(null, "BRIUP", "LOVER",new String[]{"TABLE","VIEW"});  
            //rs=metaData.getTables(null, "BRIUP", null,new String[]{"TABLE","VIEW","SEQUENCE","INDEX"});  
            //rs=metaData.getTables(null, "BRIUP", null,new String[]{"TABLE","VIEW"});  
            
            ResultSet rs=metaData.getTables(null, "BRIUP", null,new String[]{"TABLE"}); 
//			ResultSet results = null;

			
            int i = 0;
            while(rs.next())  
            {  
            	i++;
            	
                String tableName=rs.getString("TABLE_NAME");  
                String typeName=rs.getString("TABLE_TYPE");  
                System.out.println("["+tableName+"]"+"--"+typeName);  
                
                /*
                PreparedStatement pst = conn.prepareStatement("Select * From Produit");
//                pst.setString(1, tableName);
//facon2       ResultSet rsss = metaData.getColumns( null, "%", tableName, "%");
                results = pst.executeQuery();

                ResultSetMetaData rsmd = results.getMetaData();
                
                        for(int j = 0; j<rsmd.getColumnCount(); j++){
                        	String columnLabel = rsmd.getColumnLabel(j+1);
                        	String columnType = rsmd.getColumnTypeName(j+1);
                        	System.out.println(columnLabel+"\t\t\t"+columnType);
                        }
                 */
//facon 1  it is easy to show the informations of all the tables.
                ResultSet rss=metaData.getColumns(null, null,tableName,null);  
                while(rss.next())  
                {  
                    String colName=rss.getString("COLUMN_NAME");  
                    String coltypeName=rss.getString("TYPE_NAME");  
                    System.out.println(colName+":"+coltypeName);  
                } 
                
                System.out.println();

            }  
        
            
            
            
            System.out.println("Le nombre des tables dans cette BD:"+ i);

           
            


		
		
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