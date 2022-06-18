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
	
	// ����������ָ���Ƿ�����һ�������ǲ������Ͳ�һ��
	public void speak() {
		System.out.println("Let's speak wiht no param!");
	}
	
	public void speak(String str1) {
		System.out.println(str1);
	}
	
	public void speak(String str1, String str2) {
		System.out.println(str1 + str2);
	}
	
	// �ɱ������Ĳ���
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
	
	// ��ľ�̬���ԡ���̬����(�෽��)
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

// ����ģʽ
class Singleton {
	//1.˽�л����췽��ʹ�ø����޷����ⲿͨ��new����ʵ����
	private Singleton() {
		
	}
	
	//2. ׼��һ�������ԣ�ָ��һ��ʵ��������
	private static Singleton instance = new Singleton();
	
	//3. ����һ����public��������ȡ����
	public static Singleton getInstance() {
		return instance;
	}
}

class Singleton1 {
	//1.˽�л����캯����ʹ�ø����޷�ͨ���ⲿnew����ʵ����
	private Singleton1() {
		
	}
	
	//2.׼��һ�������ԣ�����ָ��һ��ʵ�������󣬵�����ʱָ��null
	private static Singleton1 instance;
	
	//3.public static����������ʵ������
	public static Singleton1 getInstance() {
		//��һ�η���ʱ�����instanceû��ָ�������ʵ����һ�� 
		if (null == instance) {
			instance = new Singleton1();
		}
		//����instanceָ��Ķ���
		return instance;
	}
	
}

public class ClassObj {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�������");
		
		Person p = new Person();
		Person p1 = p;
		Person p2 = p;
		
		// �������ָ��ͬһ������
		System.out.println(p.toString());
		System.out.println(p1.toString());
		System.out.println(p2.toString());		
		
		// ��������
		p.speak();
		p.speak("hello");
		p.speak("hello", "jonny");
		// �ɱ仯����
		p.speak("hello", "world", "hello", "jonny");
		
		Person.test();
		
		// ö��
		Season season = Season.SUMMER;
		switch(season) {
			case SPRING:
				System.out.println("����");
				break;
			case SUMMER:
				System.out.println("����");
				break;
			case AUTUMN:
				System.out.println("����");
				break;
			case WINTER:
				System.out.println("����");
				break;
		}
		
		// ����ģʽ(Singletonģʽ)����ĳ��ϵͳ�У�ĳ������ֻ��һ������˸���ֻ�ܱ�ʵ����һ��
		// ָ��һ���࣬��һ��JVM�ֻ��һ��ʵ������
		// 1.����ʽ����ģʽ��ͨ��˽�л��乹�췽����ʹ���ⲿ�޷�ͨ��new�õ��µ�ʵ����Ȼ���ṩһ��public static��getInstance
		// �������ⲿ������ͨ���÷�����ȡ����Ķ��󣬶���ÿһ�ζ��ǻ�ȡͬһ����������ģʽ������ζ���õ�һ������
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		// ����ͬһ������
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		
		//2.����ʽ����ģʽ��ֻ���ڵ���getInstanceʱ���Żᴴ��ʵ��
		Singleton1 sg1 = Singleton1.getInstance();
		Singleton1 sg2 = Singleton1.getInstance();
		Singleton1 sg3 = Singleton1.getInstance();
		// ����ͬһ������
		System.out.println(sg1 == sg2);
		System.out.println(sg1 == sg3);
		/*
		 * ����ʽ���������صķ�ʽ�������Ƿ���õ�������󣬶�����ء�
		 * ����ڹ��췽����д���������Ľϴ�ռʱ�ϾõĴ��룬���罨�������ݿ�����ӣ���ô�ͻ���������ʱ��о���΢��Щ���١�
		 * ����ʽ�����ӳټ��صķ�ʽ��ֻ��ʹ�õ�ʱ��Ż���ء� �������̰߳�ȫ�Ŀ���
		 * ʹ������ʽ����������ʱ�򣬻�о����ȶ���ʽ�Կ죬��Ϊ��û���������ʵ������ �����ڵ�һ�ε��õ�ʱ�򣬻����ʵ�����������о��Ͼ�������
		 * ��ҵ���������ҵ���������бȽϳ�ֵ������ͳ�ʼ��ʱ�䣬��ʹ�ö���ʽ�������ʹ������ʽ
		 * */
		
	}
	/*
	 * ��Ա�������������η���private(˽�е�)��package/friendly/default(��д)��protected(�ܱ�����)��public(������)
	 * ����ͨ��ʹ��private��װ������
	 * ����һ��ʹ��public���ڱ�����
	 * �ᱻ����̳еķ�����ͨ��ʹ��protected
	 *            ����        ͬ������       ��ͬ������        ͬ����        ������
	 * private    ����        �̳�          �̳�            ����          ����
	 * package    ����        �̳�          �̳�            ����          ����
	 * protected  ����        �̳�          �̳�            ����          ����
	 * public     ����        �̳�          �̳�            ����          ����
	 * */
}
