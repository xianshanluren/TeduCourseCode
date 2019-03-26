package calendar12;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * java.util.Calendar ������
 * Calendar ��һ��������, �����˲���ʱ�����ط���, ���õ�ʵ����
 * GregorianCalendar, �����������(����)
 * 
 * Calendar�ṩ�˾�̬����getInstance()���Ի�ȡ��ǰϵͳϵͳ���ڵ���ʹ�õ�ʵ����,
 * ���󲿷ֵ������صĶ�������
 * 
 * ���������(����)  GregorianCalendar : ʵ����
 * @author Administrator
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args){
		//Ĭ�ϴ�����ʾ��ǰϵͳʱ��
		Calendar calendar = Calendar.getInstance();
		//��Ϣ�ܶ�, �ɶ��Բ�
		System.out.println(calendar);
		/*
		 * Date getTime()
		 * Calendar�ṩ�˿���ת��ΪDate��getTime()����,
		 * �÷����Ὣ��ǰCalendar��ʾ��������һ��Dateʵ����ʽ
		 * ����
		 */
		Date date = calendar.getTime();//��Calendar���Date
		System.out.println(date);
		/*
		 * void setTime(Date date)
		 * ʹ��ǰCalendar��ʾ������Date����ʾ������
		 */
		calendar.setTime(date);// ��Date���Calendar
		System.out.println(calendar);
	}
}
