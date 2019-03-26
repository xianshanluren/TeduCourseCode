package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*把数据插入到数据库中**/
public class Demo03 {

/*	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String name = sc.nextLine();
		System.out.println("请输入年龄:");
		int age =Integer.parseInt(sc.nextLine());
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql = "insert into jdbc01 values(null, '"+name+"', "+age+")";
			stat.executeUpdate(sql);
			System.out.println("插入完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(rs, stat, conn);
		}
	}
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名:");
		String name = sc.nextLine();
		System.out.println("请输入年龄:");
		int age =Integer.parseInt(sc.nextLine());
		
		Connection conn = null;
		//Prepare: 提前  --> 带有预编译效果的Statement对象, 以前的statement是在执行的时候编译, 现在的是创建的时候就编译
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			//? : 是占位符, 当sql语句中出现变量的时候用问号代替
			String sql = "insert into jdbc01 values(null, ?, ?)";
			stat = conn.prepareStatement(sql);
			//把变量添加到sql语句中
			stat.setString(1, name);
			stat.setInt(2, age);
			//执行
			stat.executeUpdate();//这时执行的时候就不需要传sql语句了
			System.out.println("插入完成");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(rs, stat, conn);
		}
	}

	

}
