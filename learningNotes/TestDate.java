import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * ���е��������ͣ������������������������������ַ����������Ҫ�����ֵ���ʽ���ֳ�����
 * ��������Ҳ�����⣬���仰˵��һ�����ڣ�����2020��10��1�գ��ڼ���������һ�����������档
 * ��ô�������һ�����֣�������. ��������֣��ʹ���Java�е�ʱ��ԭ�㣬���Ӧ��������1970��1��1�� 8��0��0�� �� (Ϊʲô��8�㣬��Ϊ�й���̫ƽ��ʱ����UTC-8���պú͸�������ʱ���8��Сʱ)
 * Ϊʲô��Ӧ1970���أ� ��Ϊ1969�귢���˵�һ�� UNIX �汾��AT&T���ۺϿ��ǣ���ʱ�Ͱ�1970�굱����ʱ��ԭ�㡣
 * ���е����ڣ�������Ϊ���0��Ϊ��׼��ÿ��һ���룬��+1��
 * java.util.Date�������з�װ��
 * */
public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������ز���");
		Date d1 = new Date();
		System.out.println("��ǰʱ�䣺");
		System.out.println(d1);
		// ��1970��1��1�� ����8��0��0�� ��ʼ�����ĺ�����
		Date d2 = new Date(5000);
		System.out.println("��1970��1��1�� ����8��0��0�� ��ʼ������5���ʱ��");
		System.out.println(d2);
		
		//���ڸ�ʽ��
		//����ת�ַ���
		  
        //y ������
        //M ������
        //d ������
        //H ����24���Ƶ�Сʱ
        //h ����12���Ƶ�Сʱ
        //m �������
        //s ������
        //S �������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		Date d = new Date();
		String str8 = sdf.format(d);
		System.out.println("��ǰʱ��ͨ�� yyyy-MM-dd HH:mm:ss SSS ��ʽ����������" + str8);
		//�ַ���ת����
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String str9 = "2022/6/19 22:33:22";
		try {
			Date d3 = sdf1.parse(str9);
			System.out.printf("�ַ��� %s ͨ����ʽ yyyy/MM/dd HH:mm:ss %nת��Ϊ���ڶ���%s", str9, d3.toString());
			System.out.println();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//����
		Calendar c = Calendar.getInstance();
		Date d4 = c.getTime();
		Date d5 = new Date(0);
		c.setTime(d5);
		System.out.println(d4);
		System.out.println(c.getTime());
		
		
		Date now = c.getTime();
		System.out.println("��ǰ���ڣ�\t" + format(c.getTime())); 
		//�¸��µĽ���
		c.setTime(now);
		c.add(Calendar.MONTH, 1);
		System.out.println("�¸��µĽ��죺\t" + format(c.getTime()));
		//ȥ��Ľ���
		c.setTime(now);
		c.add(Calendar.YEAR, -1);
		System.out.println("ȥ��Ľ��죺\t" + format(c.getTime()));
		//�ϸ��µĵ�����
		c.setTime(now);
		c.add(Calendar.MONTH, -1);
		c.set(Calendar.DATE, 3);
		System.out.println("�ϸ��µĵ����죺\t" + format(c.getTime()));
	}
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static String format(Date time) {
        return sdf.format(time);
    }
}
