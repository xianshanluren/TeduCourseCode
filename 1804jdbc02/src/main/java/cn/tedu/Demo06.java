package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
/**��ҳ��ѯ�İ���*/
public class Demo06 {
//��ϰ: ������ڼ�ҳ
//	5
//������ÿҳ����
//	8
// ��ʾ  8��     ��33����40��
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ڼ�ҳ:");
		int page = Integer.parseInt(sc.nextLine());
		System.out.println("������ÿҳ��ʾ������:");
		int num = Integer.parseInt(sc.nextLine());
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			String sql = "select * from myjdbc limit ?,?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, num*(page-1)); //page count
			stat.setInt(2, num);
			rs = stat.executeQuery();
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println("id="+id+",name="+name+",age="+age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}

}
