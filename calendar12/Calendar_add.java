package calendar12;

import java.util.Calendar;

/**
 * 计算日期
 * 
 * void add(int field, int amount)
 * 对指定时间分量加上给定的值, 若给定的值是负数, 则减去
 * @author Administrator
 *
 */
public class Calendar_add {
	public static void main(String[] args) {
		//当前系统时间
		Calendar calendar = Calendar.getInstance();
		/*
		 * 查看3年2个月零25天以后是哪一天?  这一天所在的周的周三是哪一天?
		 */
		//加3年
		calendar.add(Calendar.YEAR, 3);
		//加2个月
		calendar.add(Calendar.MONTH, 2);
		//加25天
		calendar.add(Calendar.DAY_OF_YEAR, 25);
		/*
		 * 查看3年2个月零25天以后是哪一天?  这一天所在的周的周三是哪一天?
		 */
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		System.out.println(calendar.getTime());
	}
}
