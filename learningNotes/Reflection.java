/*
 * 类对象：所有的类，都存在一个类对象，这个类对象用于提供类本身的信息，比如有几种构造方法，有多少属性，有哪些普通方法。
 * 获取类对象有3种方法：
 * 1、Class.forName
 * 2、类名.class
 * 3、new 类名().getClass()
 * 在一个JVM中，一种类只有一个类对象存在。所以以上三种方式取出来的类对象都是一样的
 * 准确的讲是一个ClassLoader下，一种类，只会有一个类对象存在
 */
class RefectObj {
	public String name;
	public float hp;
	public int damage;
	public int id;

	static String copyright;
	static {
		System.out.println("初始化copyright");
		copyright = "版本由sky公司所有";
	}

	RefectObj() {
		System.out.println("Refection Object!");
	}
}

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className = "RefectObj";
//		try {
//			Class<?> pClass1 = Class.forName(className);
//			Class<?> pClass2 = RefectObj.class;
//			Class<?> pClass3 = new RefectObj().getClass();
//			System.out.println(pClass1 == pClass2);
//			System.out.println(pClass1 == pClass3);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		// 类取类对象的时候，会导致类属性被初始化
		// 无论什么途径获取类对象，都会导致静态属性被初始化，而且只会执行一次。（除了直接使用 Class c = Hero.class
		// 这种方式，这种方式不会导致静态属性被初始化）
		try {
			Class<?> pClass4 = Class.forName(className);
			Class<?> pClass5 = RefectObj.class;
			Class<?> pClass6 = new RefectObj().getClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
