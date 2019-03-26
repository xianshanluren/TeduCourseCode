package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*获得主键自增值: 球队球员练习**/
public class Demo09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入球队名称:");
		String teamName = sc.nextLine();
		System.out.println("请输入球员名称:");
		String playerName = sc.nextLine();
		sc.close();
		
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			
			//查询用户输入球队是否存在
			String sql = "select * from team where name=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, teamName);
			rs = stat.executeQuery();
			int teamId = -1;//赋值一个不可能的值
			while(rs.next()){
				//如果有数据, 需要得到球队的id
				teamId = rs.getInt("id");
			}
			
			if(teamId==-1){//没有重复的球队
				//插入球队和球员
				String sql1 = "insert into team values(null, ?)";
				stat.close();
				stat = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
				stat.setString(1, teamName);
				stat.executeUpdate();
				//得到自增主键的id: 球队id
				rs.close();
				rs = stat.getGeneratedKeys();
				while(rs.next()){
					int id = rs.getInt("id");
					//往球员表中插入球员信息
					String sql2 = "insert into player values(null, ?,?)";
					stat = conn.prepareStatement(sql2);
					stat.setString(1, playerName);
					stat.setInt(2, id);
					stat.executeUpdate();
				}
			}else{//有重复的球队
				//往现有球队里添加球员
				
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
