import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 所有的数据类型，无论是整数，布尔，浮点数还是字符串，最后都需要以数字的形式表现出来。
 * 日期类型也不例外，换句话说，一个日期，比如2020年10月1日，在计算机里，会用一个数字来代替。
 * 那么最特殊的一个数字，就是零. 零这个数字，就代表Java中的时间原点，其对应的日期是1970年1月1日 8点0分0秒 。 (为什么是8点，因为中国的太平洋时区是UTC-8，刚好和格林威治时间差8个小时)
 * 为什么对应1970年呢？ 因为1969年发布了第一个 UNIX 版本：AT&T，综合考虑，当时就把1970年当做了时间原点。
 * 所有的日期，都是以为这个0点为基准，每过一毫秒，就+1。
 * java.util.Date工具类中封装了
 * */
public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("日期相关操作");
		Date d1 = new Date();
		System.out.println("当前时间：");
		System.out.println(d1);
		// 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
		Date d2 = new Date(5000);
		System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
		System.out.println(d2);
		
		//日期格式化
		//日期转字符串
		  
        //y 代表年
        //M 代表月
        //d 代表日
        //H 代表24进制的小时
        //h 代表12进制的小时
        //m 代表分钟
        //s 代表秒
        //S 代表毫秒
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d = new Date();
		String str8 = sdf.format(d);
		System.out.println("当前时间通过 yyyy-MM-dd HH:mm:ss SSS 格式化后的输出：" + str8);
		//字符串转日期
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str9 = "2022/6/19 22:33:22";
		try {
			Date d3 = sdf1.parse(str9);
			System.out.printf("字符串 %s 通过格式 yyyy/MM/dd HH:mm:ss %n转换为日期对象：%s", str9, d3.toString());
			System.out.println();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//日历
		Calendar c = Calendar.getInstance();
		Date d4 = c.getTime();
		Date d5 = new Date(0);
		c.setTime(d5);
		System.out.println(d4);
		System.out.println(c.getTime());
		
		
		Date now = c.getTime();
		System.out.println("当前日期：\t" + format(c.getTime())); 
		//下个月的今天
		c.setTime(now);
		c.add(Calendar.MONTH, 1);
		System.out.println("下个月的今天：\t" + format(c.getTime()));
		//去年的今天
		c.setTime(now);
		c.add(Calendar.YEAR, -1);
		System.out.println("去年的今天：\t" + format(c.getTime()));
		//上个月的第三天
		c.setTime(now);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DATE, 3);
		System.out.println("上个月的第三天：\t" + format(c.getTime()));
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static String format(Date time) {
        return sdf.format(time);
    }
}
