package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*转账练习**/
public class Demo07 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			//1. 关闭自动提交功能
			conn.setAutoCommit(false);
			//2. 让超人+3000
			String sql1 = "update t_person set money=money+3000 where id=1";
			//3. 执行sql1
			stat.executeUpdate(sql1);
			//4. 让蝙蝠侠-3000
			String sql2 = "update t_person set money=money-3000 where id=2";
			//5. 执行sql2
			stat.executeUpdate(sql2);
			
			//6. 查询蝙蝠侠剩余的钱
			String sql3 = "select money from t_person where id=2";
			rs = stat.executeQuery(sql3);
			while(rs.next()){
				int money = rs.getInt("money");
				if(money>=0){
					conn.commit();
					System.out.println("转账成功");
				}else{
					conn.rollback();//回滚主要是为了避免后续操作出现问题
					System.out.println("蝙蝠侠也没钱了 ");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}

}
