package calendar12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * ����������Ҫ������ĳ��Ʒ����������, ��ʽ: yyyy-MM-dd
 * Ȼ�����������Ʒ�ı���������
 * �����������, �������Ʒ�Ĵ�������    ��ʽͬ��
 * 
 * �������ڹ���: ����Ʒ������ǰ���ܵ�����
 * @author Administrator
 *
 */
public class Test2 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������������:");
		String product = scan.nextLine();
		System.out.println("�����뱣����:");
		int saveDate = Integer.parseInt(scan.nextLine());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//��������ַ������ڽ�����Date����     ��:��������
		Date Prodate = sdf.parse(product);
		//����Calendar����
		Calendar calendar = Calendar.getInstance();
		//����������Dateת��ΪCalender����
		calendar.setTime(Prodate);
		//���������ڵĻ�����+����������-14��(����ǰ)  �õ������ڵĵ���
		calendar.add(Calendar.DAY_OF_YEAR, saveDate-14);
		//�ѵ������ó�����
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		//��calenderת����Date, ����sdf��Dateת��Ϊ�̶���ʽ������
		String promotion = sdf.format(calendar.getTime());
		System.out.println("������Ϊ:"+promotion);
		
		
	
	}
	
	
}
