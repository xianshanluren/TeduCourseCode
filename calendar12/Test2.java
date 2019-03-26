package calendar12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 程序启动后要求输入某商品的生产日期, 格式: yyyy-MM-dd
 * 然后在输入该商品的保质期天数
 * 经过程序计算, 输出该商品的促销日期    格式同上
 * 
 * 促销日期规则: 该商品过期日前两周的周三
 * @author Administrator
 *
 */
public class Test2 {
	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入生产日期:");
		String product = scan.nextLine();
		System.out.println("请输入保质期:");
		int saveDate = Integer.parseInt(scan.nextLine());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//把输入的字符串日期解析成Date日期     即:生产日期
		Date Prodate = sdf.parse(product);
		//创建Calendar对象
		Calendar calendar = Calendar.getInstance();
		//将生产日期Date转化为Calender类型
		calendar.setTime(Prodate);
		//在生产日期的基础上+保质期天数-14天(两周前)  得到的日期的当周
		calendar.add(Calendar.DAY_OF_YEAR, saveDate-14);
		//把当周设置成周三
		calendar.set(Calendar.DAY_OF_WEEK, 4);
		//把calender转化成Date, 并用sdf将Date转换为固定格式的日期
		String promotion = sdf.format(calendar.getTime());
		System.out.println("促销日为:"+promotion);
		
		
	
	}
	
	
}
