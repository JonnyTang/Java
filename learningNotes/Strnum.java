
public class Strnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("数字和字符串！");
		
		//1.封装类：所有基本类型，都有对应的类类型，这种类就叫做封装类。比如int对应的类是Integer
		int i = 100;
		Integer it = new Integer(i);
		int i2 = it.intValue();
		System.out.println(i2);
		// 数字封装类有Byte,Short,Integer,Long,Float,Double，这些类都是抽象类Number的子类
		System.out.println(it instanceof Number);
		// int的最大傎
		System.out.println(Integer.MAX_VALUE);
		// int的最小值
		System.out.println(Integer.MIN_VALUE);
		
		//2.字符串转换
		//2.1 数字转字符串
		int j = 5;
		// 方法1：使用String类的静态方法valueOf
		String str = String.valueOf(j);
		System.out.println(str);
		// 方法2：先把基本类型装箱为对象，然后调用对象的toString
		Integer jt = j;
		String str1 = jt.toString();
		System.out.println(str1);
		//2.2 字符串转数字
		//调用Integer的静态方法parseInt
		String str2 = "999";
		int i3 = Integer.parseInt(str2);
		System.out.println(i3);
		
		//3.Math方法
		//java.lang.Math提供了一些常用的数学运算方法，并且都是以静态方法的形式存在
		float f1 = 5.4f;
		float f2 = 5.5f;
		System.out.println(Math.round(f1));
		System.out.println(Math.round(f2));
		
		// 得到一个0-1之间的随机浮点数
		System.out.println(Math.random());
		// 得到一个0-10之间的随机浮点数
		System.out.println(Math.random()*10);
		System.out.println(Math.sqrt(8)); // 平方
		System.out.println(Math.pow(2,4)); // 次方(2的4次方)
		// π
		System.out.println(Math.PI);
		// 自然常数
		System.out.println(Math.E);
		
		//3.格式化输出
		//%s表示字符串；%d表示数字;%n表示换行
		String name = "JonnyTang";
		String hobbys = "football,reading and so on";
		String sentenceFormat = "%s的爱好有：%s\n";
		System.out.printf(sentenceFormat, name, hobbys);
		System.out.format(sentenceFormat, name, hobbys);
		
		//4.字符
		char c1 = 'a';
		char c2 = '1';
		char c3 = '我';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		//char对应封装类是Character
		char c4 = 'j';
		Character c5 = c4;
		c4 = c5;
		System.out.println(c4);
		System.out.println(c5);
		//Character常见的方法
		System.out.println(Character.isLetter('j')); //判断是否为字母
		System.out.println(Character.isDigit('j')); //判断是否为数字
		System.out.println(Character.isWhitespace(' ')); //是否是空白
		System.out.println(Character.isUpperCase('j')); //是否大写
		System.out.println(Character.isLowerCase('j')); //是否小写
		
		System.out.println(Character.toUpperCase('j')); //转换为大写
		System.out.println(Character.toLowerCase('J')); //转换为小写
		System.out.println(Character.toString('j')); //转换为字符串
		
		//5.操作字符串的常见方法
		String strTest = " 我是哈哈哈，你是谁！ ";
		System.out.println(strTest.charAt(0)); //根据索引返回字符
		char[] cs = strTest.toCharArray();  //获取对应字符数组
		System.out.println(strTest.length() == cs.length);
		System.out.println(strTest.substring(3));  //截取子字符串
		System.out.println(strTest.substring(2, 5));  //截取子字符串(左闭右开)
		String[] strSplit = strTest.split("，"); //分割字符串
		for (int k = 0; k < strSplit.length; k++) {
			System.out.println(strSplit[k]);
		}
		System.out.println(strTest.trim());  //去掉首尾空格
		//大小写
		String strTest1 = "I'm JonnyTang!";
		System.out.println(strTest1.toUpperCase()); //大写
		System.out.println(strTest1.toLowerCase()); //小写
		//定位
		System.out.println(strTest1.indexOf('J'));
		System.out.println(strTest1.contains("Ta"));
		//替换
		System.out.println(strTest1.replaceAll("n", "m"));
		
		//6.字符串比较
		//是否同一个对象
		String str3 = "dog";
		String str4 = new String(str1);
		System.out.println(str3 == str4); //str3和str4内容是一样的，但不是同一个对象
		String str5 = "dog";
		System.out.println(str3 == str5); //"dog"在整个内容中只有一份
		String str6 = "DOG";
		System.out.println(str3.equals(str6)); //内容是否相同
		
		//7.可变长的字符串
		String str7 = "change here ";
		StringBuffer sb = new StringBuffer(str7);
		sb.append("right now!");  //追加
		System.out.println(sb);
		sb.delete(6, 11);  //删除6-11之间的字符,左闭右开
		System.out.println(sb);
		sb.insert(7, "world"); //插入
		System.out.println(sb);
		sb.reverse();   //反转
		System.out.println(sb);
		//长度与容量
		System.out.println(sb.length());
		System.out.println(sb.capacity());
	}

}
