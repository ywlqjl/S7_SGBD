  
import java.awt.Graphics;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.FileInputStream;  
import java.sql.Blob;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import javax.imageio.ImageIO;  
import javax.swing.JFrame;  
  
public class TP5_4 {  
      
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:8889/SGBD-TP5_2";

	static final String USER = "root";
	static final String PASS = "root";
      
    {  
        try {  
            Class.forName(JDBC_DRIVER);     
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }   
    }  
      
    /* 获取连接 */  
    public Connection openConnection(){  
        try {  
            return DriverManager.getConnection(DB_URL, USER , PASS);  
        } catch (SQLException e) {  
            e.printStackTrace();  
            return null ;  
        }  
    }  
      
    /*创建表*/  
    public void createTable(){  
        try {  
            Connection conn = openConnection();  
            boolean delete = conn.prepareStatement("drop table if exists tab").execute();  
            System.out.println(delete ? "删除tab 失败" : "删除tab成功");  
            PreparedStatement ps =  
                conn.prepareStatement    
                ("CREATE TABLE `tab` (`id`  integer NULL AUTO_INCREMENT ,`img`  blob NULL ,PRIMARY KEY (`id`))");  
            boolean result = ps.execute();  
            System.out.println(result ? "创建tab失败" : "创建tab成功");  
              
            ps.close();    
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();    
        }  
    }  
      
    /*插入一条记录*/  
    public void insertTotab(){  
        try {  
            Connection conn = openConnection();  
            PreparedStatement ps =  
                    conn.prepareStatement("insert into tab(img) values(?)");  
            //设置类型为Blob  
            ps.setBlob(1, new FileInputStream(new File("/Users/yanwenli/Desktop/NEW/10-14-29-57-874.jpg")));  
        //    ps.setBlob(2 , new FileInputStream(new File("/Users/yanwenli/Desktop/00.PNG")) );  
            int i = ps.executeUpdate();    
            System.out.println(i > 0 ? "保存成功" : "保存失败");  
            ps.close();  
            conn.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /* 读取内容 */  
    public void readContent(){  
        try {  
            Connection conn = openConnection();  
            PreparedStatement ps =  
                    conn.prepareStatement("select * from tab");  
            ResultSet rs = ps.executeQuery();  
            if(rs.next()){  
                  
//                Blob file = rs.getBlob(2);  
                Blob img = rs.getBlob(2);  
  
                System.out.println("------------file-----------");  
                //读取文件流  
//                System.out.println(  
//                        IOUtils.toString(file.getBinaryStream()));  
                  
                //读取图片流  
                BufferedImage bi = ImageIO.read(img.getBinaryStream());  
                  
                //将图片流转换为图片显示出来  
                showImg(bi);   
                System.out.println("读取成功");  
            }  
              
            rs.close();  
            ps.close();    
            conn.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /* 使用JFrame显示图片 */  
    public void showImg(final BufferedImage bi ){  
        JFrame frame = new JFrame("图片测试"){  
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override  
            public void paint(Graphics g) {  
                super.paint(g);  
                g.drawImage(bi, 50 , 50 , null );  
            }    
        };  
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setBounds(0, 0, 600, 600);  //etBounds(x,y,width,height);
        frame.setVisible(true);  
    }  
      
    public static void main(String[] args) {  
    	TP5_4 jt = new TP5_4();  
        jt.createTable();  
        jt.insertTotab();  
        jt.readContent();  
    }  
      
}