package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource dataSource;
	static{
		/*向数据库连接池要连接*/
		dataSource = new BasicDataSource();
		/*从配置文件中读取数据*/
		Properties prop = new Properties();
		InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
			//取出数据
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String initSize = prop.getProperty("initSize");
			String maxSize = prop.getProperty("maxSize");
			//把读取出来的数据给连接池对象(给连接池配置连接信息)
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(Integer.parseInt(initSize));
			dataSource.setMaxActive(Integer.parseInt(maxSize));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	//获取连接
	public static Connection getConn() throws SQLException{
		//根数据库连接池要连接
		//创建池子和读取连接信息只需要一次, 所以写在静态块中(见静态块)
		return dataSource.getConnection();
	}
	//关闭资源
	public static void close(ResultSet rs, Statement stat, Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(stat!=null){
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(conn!=null){
				//在归还连接前, 把自动提交打开, 保证从池中的到的连接都是自动提交的
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
