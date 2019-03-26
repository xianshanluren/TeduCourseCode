package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo08 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql = "insert into jdbc01 values(155, '���', 90)";
			stat.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);//��������������ֵ
			//�õ����ص�����ֵ
			rs = stat.getGeneratedKeys();
			while(rs.next()){
				int id = rs.getInt(1);
				System.out.println("id="+id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}
}
