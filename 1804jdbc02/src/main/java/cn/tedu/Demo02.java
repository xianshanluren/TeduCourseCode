package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02 {
	public static void main(String[] args) throws Exception {
		/*验证连接池的等待问题:　最大连接量为３**/
	/*	Connection conn1 = DBUtils.getConn();
		System.out.println("获取连接1:"+conn1);
		
		Connection conn2 = DBUtils.getConn();
		System.out.println("获取连接2:"+conn2);
		
		Connection conn3 = DBUtils.getConn();
		System.out.println("获取连接3:"+conn3);
		conn3.close();//此时close()代表: 把连接归还给连接池    归还之后conn4 连接才能获得(归还之前conn4处于阻塞状态)
		
		Connection conn4 = DBUtils.getConn();
		System.out.println("获取连接4:"+conn4);
		*/
		DemoThread d1 = new DemoThread();
		d1.start();
		
		DemoThread d2 = new DemoThread();
		d2.start();
		
		DemoThread d3 = new DemoThread();
		d3.start();
		
		DemoThread d4 = new DemoThread();
		d4.start();
	}
}
//创建一个线程
class DemoThread extends Thread{
	@Override
	public void run() {
		//在子线程中获取连接
		try {
			Connection conn = DBUtils.getConn();
			System.out.println("连接已得到");
			Thread.sleep(5000);//sleep只能在线程中调用(属于线程中的方法)
			conn.close();//将线程归还给线程池
			System.out.println("连接已经归还");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
