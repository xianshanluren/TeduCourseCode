package calendar12;

import java.util.Calendar;

/**
 * Calendar提供了获取日期相关信息的方法:
 * int get(int field)
 * 根据给定的时间分量(单位:年月日时分秒)获取对应的值
 * 传入的int值指定对应的时间分量, 无需记住具体的值
 * Calendar提供了对应的常量
 * @author Administrator
 *
 */
public class Calendar_get {
	public static void main(String[] args) {
		//当前系统时间
		Calendar calendar = Calendar.getInstance();
		
		//获取年
		int year = calendar.get(calendar.YEAR );
		System.out.println(year);
		//获取月   月从0开始   0表示1月  以此类推
		int month = calendar.get(calendar.MONTH)+1;
		System.out.println(month);
		/*
		 * 获取日  
		 *  DAY_OF_MONTH: 一月的某一天     
		 *   DAY_OF_WEEK:一周的某一天      
		 *    DAY_OF_YEAR:一年的某天 
		 *     DATE == DAY_OF_MONTH: 一月的某天
		 */
		int day = calendar.get(calendar.DATE);
		System.out.println(year+"-"+month+"-"+day);
		
		//获取时     HOUR: 12小时制  HOUR_OF_DAY: 24小时制
		int hour = calendar.get(calendar.HOUR);
		//获取分  MINUTE
		int minute = calendar.get(calendar.MINUTE);
		//获取秒   SECOND
		int second = calendar.get(calendar.SECOND);
		System.out.println("时间:"+hour+":"+minute+":"+second);
		
		//获取周几
		String[] date = {"日","一","二","三","四","五","六"};
		int week = calendar.get(calendar.DAY_OF_WEEK)-1;
		System.out.println("周"+date[week]);
		
		//今天是今年的第几天
		int dayYear = calendar.get(calendar.DAY_OF_YEAR);
		System.out.println(dayYear);
		
		//月底,年底,
		/*
		 * 获取指定时间分量所允许的最大值
		 */
		int d = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(d);
		
	}
}
