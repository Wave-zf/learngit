package message.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class JdbcUntil {
	
	private static String url=null;
	private static String user=null;
	private static String password=null;
	private static String driverClass = null;
	
	
	static{
		try {
			//读取db.properties文件
			Properties props =new Properties();
			InputStream in = JdbcUntil.class.getResourceAsStream("/db.properties");
			
			props.load(in);
			//读取信息
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			driverClass = props.getProperty("driverClass");
			//注册驱动程序
			System.out.println(url);
			System.out.println(user);
			System.out.println(password);
			System.out.println(driverClass);
			
			
			
			
			Class.forName(driverClass);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("注册驱动程序出错");
		}
	}
	
	//连接对象的方法
	public static Connection getConnection(){
		try {
			Connection conn= (Connection) DriverManager.getConnection(url,user,password);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	//释放资源的方法
	public static void close(Connection conn ,Statement stmt){
		if(stmt!=null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
	}
	//重载
	public static void close(Connection conn ,Statement stmt,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
				stmt=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		if(conn!=null){
			try {
				conn.close();
				conn=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	
	}
	

}
