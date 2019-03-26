package calendar12;

import java.util.Calendar;

/**
 * Calendar�ṩ�˻�ȡ���������Ϣ�ķ���:
 * int get(int field)
 * ���ݸ�����ʱ�����(��λ:������ʱ����)��ȡ��Ӧ��ֵ
 * �����intֵָ����Ӧ��ʱ�����, �����ס�����ֵ
 * Calendar�ṩ�˶�Ӧ�ĳ���
 * @author Administrator
 *
 */
public class Calendar_get {
	public static void main(String[] args) {
		//��ǰϵͳʱ��
		Calendar calendar = Calendar.getInstance();
		
		//��ȡ��
		int year = calendar.get(calendar.YEAR );
		System.out.println(year);
		//��ȡ��   �´�0��ʼ   0��ʾ1��  �Դ�����
		int month = calendar.get(calendar.MONTH)+1;
		System.out.println(month);
		/*
		 * ��ȡ��  
		 *  DAY_OF_MONTH: һ�µ�ĳһ��     
		 *   DAY_OF_WEEK:һ�ܵ�ĳһ��      
		 *    DAY_OF_YEAR:һ���ĳ�� 
		 *     DATE == DAY_OF_MONTH: һ�µ�ĳ��
		 */
		int day = calendar.get(calendar.DATE);
		System.out.println(year+"-"+month+"-"+day);
		
		//��ȡʱ     HOUR: 12Сʱ��  HOUR_OF_DAY: 24Сʱ��
		int hour = calendar.get(calendar.HOUR);
		//��ȡ��  MINUTE
		int minute = calendar.get(calendar.MINUTE);
		//��ȡ��   SECOND
		int second = calendar.get(calendar.SECOND);
		System.out.println("ʱ��:"+hour+":"+minute+":"+second);
		
		//��ȡ�ܼ�
		String[] date = {"��","һ","��","��","��","��","��"};
		int week = calendar.get(calendar.DAY_OF_WEEK)-1;
		System.out.println("��"+date[week]);
		
		//�����ǽ���ĵڼ���
		int dayYear = calendar.get(calendar.DAY_OF_YEAR);
		System.out.println(dayYear);
		
		//�µ�,���,
		/*
		 * ��ȡָ��ʱ���������������ֵ
		 */
		int d = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(d);
		
	}
}
