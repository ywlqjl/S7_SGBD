//STEP 1. Import required packages
// In this part, we will draw a picture using the datas from BD 
// By "Jfree.chart"
// There are so many packages and fonctions
// Eg: we haven't used JPanel

import java.sql.*;
import java.text.NumberFormat;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class TD2b {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TD2b";

	static final String USER = "root";
	static final String PASS = "root";
	private static int arrays[];

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {

			
			Class.forName("com.mysql.jdbc.Driver");
			
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			System.out.println("Creating tables in given database...");
			stmt = conn.createStatement();

	/*		String NoteFiche = "CREATE TABLE NoteFiche "
					+ "(Code INTEGER not NULL PRIMARY KEY , "
					+ " Nom VARCHAR(255), " 
					+ " Metier VARCHAR(255)," 
					+ " Level VARCHAR(255),"
					+ " Note INTEGER) ";

			stmt.executeUpdate(NoteFiche);
			
	*/		

// =========== Insert records into the table =====================================================================//
/*
			System.out.println("Inserting records into the table...");
			// reuse AddData
			String AddData = "INSERT INTO NoteFiche " + " VALUES (001, 'Apple', 'Math', 'A',18) ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO NoteFiche " + " VALUES (002, 'Banana', 'Math', 'A', 19) ";
			stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO NoteFiche " + " VALUES (003, 'Orange', 'Informatique','B', 11) ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO NoteFiche " + " VALUES (004, 'Meimei', 'Math','B', 10.5) ";
			stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO NoteFiche " + " VALUES (005, 'Youyou', 'Math','C', 8) ";
			stmt.executeUpdate(AddData);

			AddData = "INSERT INTO NoteFiche " + " VALUES (006, 'Youyou', 'Informatique', 'B', 12) ";
			stmt.executeUpdate(AddData);
			
			AddData = "INSERT INTO NoteFiche " + " VALUES (007, 'Apple', 'Informatique', 'C', 6) ";
			stmt.executeUpdate(AddData);

			
			System.out.println("Insert data successfully...");
		
	*/		
// =========== a. Show the graph of the report by JFreeChart =================================================================//

			int i = 0;
			arrays = new int[4];
			String calcul = "SELECT Level, count(Level) AS nombre   FROM NoteFiche WHERE Metier = 'Math'  GROUP BY Level";
			PreparedStatement infoISBN = conn.prepareStatement(calcul);
			ResultSet rs = infoISBN.executeQuery();
			
	/*		while (rs.next()) {
	            String Level = rs.getString("Level");
	            int Nom = rs.getInt("nombre");
	            System.out.println(Level+ "\t\t" + Nom );	  
			}
		*/	
			
			
			while (rs.next()) {
	             arrays[i] = rs.getInt("nombre");
	             i++;
			}
			System.out.println("A"+"\t\t"+arrays[0]+'\n'+"B"+"\t\t"+arrays[1]+'\n'+"C"+"\t\t"+arrays[2]);
			
			
			DefaultPieDataset dpd=new DefaultPieDataset(); //建立一个默认的饼图
			
	        dpd.setValue("A", arrays[0]);  //输入数据 insert data
	        dpd.setValue("B", arrays[1]);
	        dpd.setValue("C", arrays[2]);
	        
	      //  ChartPanel chartpanel = new ChartPanel(timeSeriesChart, true);
	        
	        JFreeChart chart=ChartFactory.createPieChart("Les notes de Math",dpd,true,true,false); 
	        //可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
	        ChartFrame chartFrame=new ChartFrame("Les notes de Math",chart);
	        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
	        PiePlot piePlot = (PiePlot) chart.getPlot();
	        piePlot.setCircular(true);//圆形还是椭圆circle or not
	        StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator("{0}:({1}.{2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());  
	        piePlot.setLabelGenerator(standarPieIG); 
	        chartFrame.pack(); //以合适的大小展现图形 suitable size
	        chartFrame.setVisible(true);//图形是否可见 if we can see the image
	      
	        
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