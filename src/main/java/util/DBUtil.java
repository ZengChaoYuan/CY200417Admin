package util;
 

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
 
public class DBUtil {
    
	private static Properties pro=new Properties();
	
	static {
		try {
			InputStream inputStream=DBUtil.class.getClassLoader().getResourceAsStream("config.properties");
			pro.load(inputStream);
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		
		try {
			Class.forName(pro.getProperty("driver"));
			String url=pro.getProperty("url");
			String username=pro.getProperty("name");
			String password=pro.getProperty("password");
			conn=DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeConn(Connection conn,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}