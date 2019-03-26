package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/*�����ݲ��뵽���ݿ���**/
public class Demo03 {

/*	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���:");
		String name = sc.nextLine();
		System.out.println("����������:");
		int age =Integer.parseInt(sc.nextLine());
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql = "insert into jdbc01 values(null, '"+name+"', "+age+")";
			stat.executeUpdate(sql);
			System.out.println("�������");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(rs, stat, conn);
		}
	}
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���:");
		String name = sc.nextLine();
		System.out.println("����������:");
		int age =Integer.parseInt(sc.nextLine());
		
		Connection conn = null;
		//Prepare: ��ǰ  --> ����Ԥ����Ч����Statement����, ��ǰ��statement����ִ�е�ʱ�����, ���ڵ��Ǵ�����ʱ��ͱ���
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			//? : ��ռλ��, ��sql����г��ֱ�����ʱ�����ʺŴ���
			String sql = "insert into jdbc01 values(null, ?, ?)";
			stat = conn.prepareStatement(sql);
			//�ѱ�����ӵ�sql�����
			stat.setString(1, name);
			stat.setInt(2, age);
			//ִ��
			stat.executeUpdate();//��ʱִ�е�ʱ��Ͳ���Ҫ��sql�����
			System.out.println("�������");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(rs, stat, conn);
		}
	}

	

}
