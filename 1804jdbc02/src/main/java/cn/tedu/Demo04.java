package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		//得到用户输入的用户名和密码
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名: ");
		String username = sc.nextLine();
		System.out.println("请输入密码: ");
		String password = sc.nextLine();
		boolean b = login(username, password);
		if(b){
			System.out.println("登陆成功");
		}else{
			System.err.println("登陆失败");
			
		}
	}
	
	//登陆的业务
	public static boolean login(String username, String password){
		Connection conn = null;
		/*Statement stat = null;*/
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			/*stat = conn.createStatement();*/
			/*//登陆的sql
			String sql = "select count(*) from user where username='"+username+"' and password='"+password+"'";
			//sql注入:  ' or '1'='1
			rs = stat.executeQuery(sql);*/
//			以上代码存在sql注入风险
			
//			使用PreparedStatement可以避免SQL注入
			String sql = "select count(*) from user where username=? and password=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			//执行SQL
			rs = stat.executeQuery();
			
			while(rs.next()){
				//获取结果集中的唯一一个数
				int count = rs.getInt(1);
				//count=0的话返回false, count>0的话返回true
				return count>0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
		return false;
	}
	
}
