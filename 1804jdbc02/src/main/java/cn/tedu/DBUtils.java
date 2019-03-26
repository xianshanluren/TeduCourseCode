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
		/*�����ݿ����ӳ�Ҫ����*/
		dataSource = new BasicDataSource();
		/*�������ļ��ж�ȡ����*/
		Properties prop = new Properties();
		InputStream ips = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(ips);
			//ȡ������
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			String initSize = prop.getProperty("initSize");
			String maxSize = prop.getProperty("maxSize");
			//�Ѷ�ȡ���������ݸ����ӳض���(�����ӳ�����������Ϣ)
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
	//��ȡ����
	public static Connection getConn() throws SQLException{
		//�����ݿ����ӳ�Ҫ����
		//�������ӺͶ�ȡ������Ϣֻ��Ҫһ��, ����д�ھ�̬����(����̬��)
		return dataSource.getConnection();
	}
	//�ر���Դ
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
				//�ڹ黹����ǰ, ���Զ��ύ��, ��֤�ӳ��еĵ������Ӷ����Զ��ύ��
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
