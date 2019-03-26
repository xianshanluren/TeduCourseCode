package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDAO {
	Connection conn = null;
	PreparedStatement stat = null;
	ResultSet rs = null;
	
	/**
	 * ɾ��ָ��id���û�
	 * @throws SQLException 
	 */
	public void delete(int id) throws SQLException{
		try {
			conn = DBUtils.getConn();
			String sql = "DELETE FROM t_user WHERE id=?";
			stat = conn.prepareStatement(sql);
			stat.setInt(1, id);
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.close(null, stat, conn);
		}
		
	}
	
	
	/**
	 * ���û���Ϣ���뵽t_user����
	 * @return
	 * @throws SQLException
	 */
	public void save(User user) throws SQLException{
		try {
			conn = DBUtils.getConn();
			String sql = "INSERT INTO t_user VALUES (null, ?, ?, ?)";
			stat = conn.prepareStatement(sql);
			stat.setString(1, user.getUsername());
			stat.setString(2, user.getPassword());
			stat.setString(3, user.getEmail());
			//ִ��SQL
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.close(null, stat, conn);
		}
	}
	
	/*
	 * ��t_user���в�ѯ�����û�����Ϣ
	 * ע: 
	 * 		һ����¼��Ӧһ��User����(������¼�е����ݴ�ŵ�User��������).
	 */
	public List<User> findAll() throws SQLException{
		List<User> users = new ArrayList<User>();
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM t_user";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			//��������е����ݴ�ŵ�User������
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				User user = new User();
				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
				user.setEmail(email);
				
				users.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			/*������û�û��ֱ�ӵĽ���, ����û�����������쳣, ��Ҫ���쳣�׳�ȥ,��service��������ʱ,
			 *  service�����������������û�ϵͳ��æ...*/
			throw e;
		} finally{
			DBUtils.close(rs, stat, conn);
		}
		
		return users;
	}
}
