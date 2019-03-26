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
	 * 删除指定id的用户
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
	 * 将用户信息插入到t_user表中
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
			//执行SQL
			stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally{
			DBUtils.close(null, stat, conn);
		}
	}
	
	/*
	 * 从t_user表中查询所有用户的信息
	 * 注: 
	 * 		一条记录对应一个User对象(即将记录中的数据存放到User对象里面).
	 */
	public List<User> findAll() throws SQLException{
		List<User> users = new ArrayList<User>();
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM t_user";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			//将结果集中的数据存放到User对象中
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
			/*本类和用户没有直接的交互, 所以没有能力处理异常, 需要将异常抛出去,等service方法调用时,
			 *  service方法才有能力告诉用户系统繁忙...*/
			throw e;
		} finally{
			DBUtils.close(rs, stat, conn);
		}
		
		return users;
	}
}
