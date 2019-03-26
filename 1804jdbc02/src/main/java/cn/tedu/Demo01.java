package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
//����DBUtils������
public class Demo01 {
	
	//���Եõ�������
	@Test
	public void test01(){
		try {
			Connection conn = DBUtils.getConn();
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//���Բ������
	@Test
	public void findAll(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConn();
			//�õ�ִ��sql���Ķ���
			stat = conn.createStatement();
			//ִ��
			rs = stat.executeQuery("select * from emp");
			//����rs��whileѭ��
			while(rs.next()){
				String name = rs.getString("ename");
				System.out.println("Ա������:"+name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtils.close(rs, stat, conn);
		}
	}
}
