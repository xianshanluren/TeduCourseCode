package calendar12;

import java.util.Calendar;

/**
 * ��������
 * 
 * void add(int field, int amount)
 * ��ָ��ʱ��������ϸ�����ֵ, ��������ֵ�Ǹ���, ���ȥ
 * @author Administrator
 *
 */
public class Calendar_add {
	public static void main(String[] args) {
		//��ǰϵͳʱ��
		Calendar calendar = Calendar.getInstance();
		/*
		 * �鿴3��2������25���Ժ�����һ��?  ��һ�����ڵ��ܵ���������һ��?
		 */
		//��3��
		calendar.add(Calendar.YEAR, 3);
		//��2����
		calendar.add(Calendar.MONTH, 2);
		//��25��
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		/*
		 * �鿴3��2������25���Ժ�����һ��?  ��һ�����ڵ��ܵ���������һ��?
		 */
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		System.out.println(calendar.getTime());
	}
}
