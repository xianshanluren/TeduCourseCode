package calendar12;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * java.util.Calendar 日历类
 * Calendar 是一个抽象类, 定义了操作时间的相关方法, 常用的实现类
 * GregorianCalendar, 即格里高里历(阳历)
 * 
 * Calendar提供了静态方法getInstance()可以获取当前系统系统所在地区使用的实现类,
 * 绝大部分地区返回的都是阳历
 * 
 * 格里高里历(阳历)  GregorianCalendar : 实现类
 * @author Administrator
 *
 */
public class CalendarDemo1 {
	public static void main(String[] args){
		//默认创建表示当前系统时间
		Calendar calendar = Calendar.getInstance();
		//信息很多, 可读性差
		System.out.println(calendar);
		/*
		 * Date getTime()
		 * Calendar提供了可以转换为Date的getTime()方法,
		 * 该方法会将当前Calendar表示的日期以一个Date实例形式
		 * 返回
		 */
		Date date = calendar.getTime();//把Calendar变成Date
		System.out.println(date);
		/*
		 * void setTime(Date date)
		 * 使当前Calendar表示给定的Date所表示的日期
		 */
		calendar.setTime(date);// 把Date变成Calendar
		System.out.println(calendar);
	}
}
