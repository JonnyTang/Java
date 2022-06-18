class Person {
	private String name;
	private int power;
	
	public Person() {
		System.out.println("I'm a Person!");
	}
	
	public Person(String name, int power) {
		this.setName(name);
		this.setPower(power);
	}
	
	// 方法的重载指的是方法名一样，但是参数类型不一样
	public void speak() {
		System.out.println("Let's speak wiht no param!");
	}
	
	public void speak(String str1) {
		System.out.println(str1);
	}
	
	public void speak(String str1, String str2) {
		System.out.println(str1 + str2);
	}
	
	// 可变数量的参数
	public void speak(String... strs) {
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	// 类的静态属性、静态方法(类方法)
	static int len = 100;
	static public void test() {
		System.out.println(len);
	}
}

class Man extends Person {
	public Man() {
		System.out.println("I'm a Man!");
	}
}

class Women extends Person {
	public Women() {
		System.out.println("I'm a Woman!");
	}
}

enum Season {
	SPRING, SUMMER, AUTUMN, WINTER
}

// 单例模式
class Singleton {
	//1.私有化构造方法使得该类无法在外部通过new进行实例化
	private Singleton() {
		
	}
	
	//2. 准备一个类属性，指向一个实例化对象。
	private static Singleton instance = new Singleton();
	
	//3. 定义一个类public方法来获取对象
	public static Singleton getInstance() {
		return instance;
	}
}

class Singleton1 {
	//1.私有化构造函数，使得该类无法通过外部new进行实例化
	private Singleton1() {
		
	}
	
	//2.准备一个类属性，用于指向一个实例化对象，但是暂时指向null
	private static Singleton1 instance;
	
	//3.public static方法，返回实例对象
	public static Singleton1 getInstance() {
		//第一次访问时，如果instance没有指向对象，则实例化一个 
		if (null == instance) {
			instance = new Singleton1();
		}
		//返回instance指向的对象
		return instance;
	}
	
}

public class ClassObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("类与对象！");
		
		Person p = new Person();
		Person p1 = p;
		Person p2 = p;
		
		// 多个引用指向同一个对象
		System.out.println(p.toString());
		System.out.println(p1.toString());
		System.out.println(p2.toString());		
		
		// 函数重载
		p.speak();
		p.speak("hello");
		p.speak("hello", "jonny");
		// 可变化参数
		p.speak("hello", "world", "hello", "jonny");
		
		Person.test();
		
		// 枚举
		Season season = Season.SUMMER;
		switch(season) {
			case SPRING:
				System.out.println("春天");
				break;
			case SUMMER:
				System.out.println("夏天");
				break;
			case AUTUMN:
				System.out.println("秋天");
				break;
			case WINTER:
				System.out.println("冬天");
				break;
		}
		
		// 单例模式(Singleton模式)：在某个系统中，某个东西只有一个，因此该类只能被实例化一次
		// 指的一个类，在一个JVM里，只有一个实例存在
		// 1.饿汉式单例模式：通过私有化其构造方法，使得外部无法通过new得到新的实例，然后提供一个public static的getInstance
		// 方法，外部调用者通过该方法获取定义的对象，而且每一次都是获取同一个对象。这种模式无论如何都会得到一个对象
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		// 都是同一个对象
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		//2.懒汉式单例模式：只有在调用getInstance时，才会创建实例
		Singleton1 sg1 = Singleton1.getInstance();
		Singleton1 sg2 = Singleton1.getInstance();
		Singleton1 sg3 = Singleton1.getInstance();
		// 都是同一个对象
		System.out.println(sg1 == sg2);
		System.out.println(sg1 == sg3);
		/*
		 * 饿汉式是立即加载的方式，无论是否会用到这个对象，都会加载。
		 * 如果在构造方法里写了性能消耗较大，占时较久的代码，比如建立与数据库的连接，那么就会在启动的时候感觉稍微有些卡顿。
		 * 懒汉式，是延迟加载的方式，只有使用的时候才会加载。 并且有线程安全的考量
		 * 使用懒汉式，在启动的时候，会感觉到比饿汉式略快，因为并没有做对象的实例化。 但是在第一次调用的时候，会进行实例化操作，感觉上就略慢。
		 * 看业务需求，如果业务上允许有比较充分的启动和初始化时间，就使用饿汉式，否则就使用懒汉式
		 * */
		
	}
	/*
	 * 成员变量有四种修饰符：private(私有的)、package/friendly/default(不写)、protected(受保护的)、public(公共的)
	 * 属性通常使用private封装起来；
	 * 方法一般使用public用于被调用
	 * 会被子类继承的方法，通常使用protected
	 *            自身        同包子类       不同包子类        同包类        其他类
	 * private    访问        继承          继承            访问          访问
	 * package    访问        继承          继承            访问          访问
	 * protected  访问        继承          继承            访问          访问
	 * public     访问        继承          继承            访问          访问
	 * */
}
