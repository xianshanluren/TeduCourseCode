package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
/*����ִ��SQL**/
public class Demo05 {

	@Test
	public void test01(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql1 = "insert into jdbc01 values(null, '���', 34)";
			String sql2 = "insert into jdbc01 values(null, '�˽�', 100)";
			String sql3 = "insert into jdbc01 values(null, 'ɳɮ', 455)";
			stat.addBatch(sql1);
			stat.addBatch(sql2);
			stat.addBatch(sql3);
			//����ֵ��int���͵�����, ���汣�����ÿ��sql�����Ч������
			stat.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}
	
	@Test
	public void test02(){
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			String sql = "insert into jdbc01 values(null, ?, ?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, "ˮ��");
			stat.setInt(2, 35);
			//��ӵ���������
			stat.addBatch();
			
			stat.setString(1, "�׹Ǿ�");
			stat.setInt(2, 877);
			//��ӵ���������
			stat.addBatch();
			
			stat.setString(1, "����");
			stat.setInt(2, 88);
			//��ӵ���������
			stat.addBatch();
			
			//ִ����������
			stat.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}
	
	@Test
	public void test03(){
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			String sql = "insert into myjdbc values(?, ?, ?)";
			stat = conn.prepareStatement(sql);
			for(int i=1; i<101; i++){
				stat.setInt(1, 100+i);
				stat.setString(2, "n"+i);
				stat.setInt(3,i+10 );
				stat.addBatch();
				//����ִ��(ÿ��20������, ִ��һ��:�����ڴ����)
				if(i%20==0){
					stat.executeBatch();
					stat.clearBatch();//���ִ�й���sql
				}
			}
			//Ϊ�˱�������©, �����ִ��һ��
			stat.executeBatch();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}
}
