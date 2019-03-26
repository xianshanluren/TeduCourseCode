package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*ת����ϰ**/
public class Demo07 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			//1. �ر��Զ��ύ����
			conn.setAutoCommit(false);
			//2. �ó���+3000
			String sql1 = "update t_person set money=money+3000 where id=1";
			//3. ִ��sql1
			stat.executeUpdate(sql1);
			//4. ��������-3000
			String sql2 = "update t_person set money=money-3000 where id=2";
			//5. ִ��sql2
			stat.executeUpdate(sql2);
			
			//6. ��ѯ������ʣ���Ǯ
			String sql3 = "select money from t_person where id=2";
			rs = stat.executeQuery(sql3);
			while(rs.next()){
				int money = rs.getInt("money");
				if(money>=0){
					conn.commit();
					System.out.println("ת�˳ɹ�");
				}else{
					conn.rollback();//�ع���Ҫ��Ϊ�˱������������������
					System.out.println("������ҲûǮ�� ");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}

}
