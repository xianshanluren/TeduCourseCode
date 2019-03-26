package cn.tedu;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class Demo10 {

	
	@Test
	public void test01(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;

		try {
			conn = DBUtils.getConn();

			//得到数据库的元数据
			DatabaseMetaData data = conn.getMetaData();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, stat, conn);
		}
	}
}
