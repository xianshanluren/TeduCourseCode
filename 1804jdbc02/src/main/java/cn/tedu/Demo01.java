package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
//测试DBUtils工具类
public class Demo01 {
	
	//测试得到的连接
	@Test
	public void test01(){
		try {
			Connection conn = DBUtils.getConn();
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//测试查找语句
	@Test
	public void findAll(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			//得到执行sql语句的对象
			stat = conn.createStatement();
			//执行
			rs = stat.executeQuery("select * from emp");
			//见到rs就while循环
			while(rs.next()){
				String name = rs.getString("ename");
				System.out.println("员工姓名:"+name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(rs, stat, conn);
		}
	}
}
