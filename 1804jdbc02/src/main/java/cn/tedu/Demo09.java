package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*�����������ֵ: �����Ա��ϰ**/
public class Demo09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������������:");
		String teamName = sc.nextLine();
		System.out.println("��������Ա����:");
		String playerName = sc.nextLine();
		sc.close();
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			
			//��ѯ�û���������Ƿ����
			String sql = "select * from team where name=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, teamName);
			rs = stat.executeQuery();
			int teamId = -1;//��ֵһ�������ܵ�ֵ
			while(rs.next()){
				//���������, ��Ҫ�õ���ӵ�id
				teamId = rs.getInt("id");
			}
			
			if(teamId==-1){//û���ظ������
				//������Ӻ���Ա
				String sql1 = "insert into team values(null, ?)";
				stat.close();
				stat = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
				stat.setString(1, teamName);
				stat.executeUpdate();
				//�õ�����������id: ���id
				rs.close();
				rs = stat.getGeneratedKeys();
				while(rs.next()){
					int id = rs.getInt("id");
					//����Ա���в�����Ա��Ϣ
					String sql2 = "insert into player values(null, ?,?)";
					stat = conn.prepareStatement(sql2);
					stat.setString(1, playerName);
					stat.setInt(2, id);
					stat.executeUpdate();
				}
			}else{//���ظ������
				//����������������Ա
				
				String sql2 = "insert into player values(null, ?,?)";
				stat.close();
				stat = conn.prepareStatement(sql2);
				stat.setString(1, playerName);
				stat.setInt(2, teamId);
				stat.executeUpdate();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
		
		
		
		
		
		
		
	}

}
