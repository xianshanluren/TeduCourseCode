package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		//�õ��û�������û���������
		Scanner sc = new Scanner(System.in);
		System.out.println("�������û���: ");
		String username = sc.nextLine();
		System.out.println("����������: ");
		String password = sc.nextLine();
		boolean b = login(username, password);
		if(b){
			System.out.println("��½�ɹ�");
		}else{
			System.err.println("��½ʧ��");
			
		}
	}
	
	//��½��ҵ��
	public static boolean login(String username, String password){
		Connection conn = null;
		/*Statement stat = null;*/
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			/*stat = conn.createStatement();*/
			/*//��½��sql
			String sql = "select count(*) from user where username='"+username+"' and password='"+password+"'";
			//sqlע��:  ' or '1'='1
			rs = stat.executeQuery(sql);*/
//			���ϴ������sqlע�����
			
//			ʹ��PreparedStatement���Ա���SQLע��
			String sql = "select count(*) from user where username=? and password=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, password);
			//ִ��SQL
			rs = stat.executeQuery();
			
			while(rs.next()){
				//��ȡ������е�Ψһһ����
				int count = rs.getInt(1);
				//count=0�Ļ�����false, count>0�Ļ�����true
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
