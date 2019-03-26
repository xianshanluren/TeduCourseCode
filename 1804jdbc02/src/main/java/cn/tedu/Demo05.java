package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
/*批量执行SQL**/
public class Demo05 {

	@Test
	public void test01(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();
			stat = conn.createStatement();
			String sql1 = "insert into jdbc01 values(null, '悟空', 34)";
			String sql2 = "insert into jdbc01 values(null, '八戒', 100)";
			String sql3 = "insert into jdbc01 values(null, '沙僧', 455)";
			stat.addBatch(sql1);
			stat.addBatch(sql2);
			stat.addBatch(sql3);
			//返回值是int类型的数组, 里面保存的是每条sql语句生效的行数
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
			stat.setString(1, "水月");
			stat.setInt(2, 35);
			//添加到批量操作
			stat.addBatch();
			
			stat.setString(1, "白骨精");
			stat.setInt(2, 877);
			//添加到批量操作
			stat.addBatch();
			
			stat.setString(1, "妖怪");
			stat.setInt(2, 88);
			//添加到批量操作
			stat.addBatch();
			
			//执行批量操作
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
				//分批执行(每隔20条数据, 执行一次:避免内存溢出)
				if(i%20==0){
					stat.executeBatch();
					stat.clearBatch();//清空执行过的sql
				}
			}
			//为了避免有遗漏, 最后再执行一次
			stat.executeBatch();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}
}
