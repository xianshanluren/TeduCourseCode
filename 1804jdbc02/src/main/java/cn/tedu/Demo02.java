package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo02 {
	public static void main(String[] args) throws Exception {
		/*��֤���ӳصĵȴ�����:�����������Ϊ��**/
	/*	Connection conn1 = DBUtils.getConn();
		System.out.println("��ȡ����1:"+conn1);
		
		Connection conn2 = DBUtils.getConn();
		System.out.println("��ȡ����2:"+conn2);
		
		Connection conn3 = DBUtils.getConn();
		System.out.println("��ȡ����3:"+conn3);
		conn3.close();//��ʱclose()����: �����ӹ黹�����ӳ�    �黹֮��conn4 ���Ӳ��ܻ��(�黹֮ǰconn4��������״̬)
		
		Connection conn4 = DBUtils.getConn();
		System.out.println("��ȡ����4:"+conn4);
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
//����һ���߳�
class DemoThread extends Thread{
	@Override
	public void run() {
		//�����߳��л�ȡ����
		try {
			Connection conn = DBUtils.getConn();
			System.out.println("�����ѵõ�");
			Thread.sleep(5000);//sleepֻ�����߳��е���(�����߳��еķ���)
			conn.close();//���̹߳黹���̳߳�
			System.out.println("�����Ѿ��黹");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
