// 1）接口：就像一种约定， 实现某个接口，就相当于承诺了某种约定
// 不要加public约束，不然需要弄成单个文件
interface Flyer {
	public void fly();
}

class Bird implements Flyer {
	@Override
	public void fly() {
		System.out.println("I'm a bird, I can fly!");
	}
}

// 2）对象转换
// 父类
class Parent {
	public String name;

	public void say() {
		System.out.println("I'm Parent!");
	}

	public static void dance() {
		System.out.println("Parent dance!");
	}

	public Parent() {
		System.out.println("This is Parent Constructor!");
	}

	// 有参构建函数
	public Parent(String name) {
		System.out.println("This is Parent's constructor with params！");
		this.name = name;
	}

	public void finalize() {
		System.out.println("这个父类正在被回收");
	}
	
	public boolean equals(Object o) {
		if (o instanceof Parent) {
			Parent p = (Parent)o;
			return this.name == p.name;
		}
		return false;
	}
}

// 子类
class Child extends Parent {
	public int grade;

	@Override
	public void say() {
		System.out.println("I'm Child!");
	}

	public static void dance() {
		System.out.println("Child dance!");
	}

	public Child() {
		System.out.println("This is Child constructor!");
	}

	// 有参构建函数
	public Child(String name) {
		super(name);
		System.out.println("This is Child constructor with params!");
	}
}

class Child1 extends Parent {
	public int age;

	@Override
	public void say() {
		System.out.println("I'm Child1!");
	}
}

public class Inherit {
	public static void main(String[] args) {
		System.out.println("接口和继承！！！");

		// 1、接口
		Bird b = new Bird();
		b.fly();

		// 2、对象转换
		// 2.1 向上转换，所有子类转换成父类是可以通的
		Parent p = new Parent();
		Child c = new Child(); // 子类实例时，父类也会实例化，其构建函数会被调用
		p = c;
		p.say();
		// 2.2 向下转换，父类转换成子类，不一定，强制转换，后果自负
//		c = (Child) p;
//		c.say();
		// 2.3 两个没有继承关系的类不能转换
		Child c1 = new Child();
		Child1 c2 = new Child1();
//		c1 = (Child)c2;  // 会出现编译错误
		c1.say();
		c2.say();
		// 2.4 类向上转成接口
		Bird b1 = new Bird();
		Flyer f = b1; // Bird类实现了接口
		f.fly();

		// 判断对象是否为某类型
		System.out.println(b1 instanceof Bird);

		// 3. 重写
		// 子类可以继承父类的对象方法，在继承后，重复提供该方法，就叫做方法的重写，又叫覆盖override
		System.out.println("override!!!");
		Parent p2 = new Parent();
		Child c3 = new Child();
		p2.say();
		c3.say();

		// 4. 多态
		// 操作符的多态：+可以作为算数运算，也可以作为字符串连接；
		// 类的多态：父类引用指向子类对象。
		/*
		 * 实现类的多态，需要如下条件： 1）父类或接口引用指向子类对象 2）调用的方法有重写
		 */
		int i = 2;
		int j = 3;
		int k = i + j; // 如果+号两侧都是整数，那么+代表数字相加
		System.out.println(k);

		int a = 5;
		String str1 = "5";
		String str = a + str1; // 如果+两侧，其中有一个是字符串，则+代表字符串连接
		System.out.println(str);

		// 5. 隐藏
		// 隐藏就是子类覆盖父类的类方法
		Parent.dance();
		Child.dance();

		// 6. super
		new Parent("Jonny");
		new Child("xiaoduo");

		// 7. Object类，Object类是所有类的子类。声明一个类的时候，默认是继承了Object
		Parent dan = new Parent("xiaodan");
		System.out.println(dan.toString());
		// 当一个对象没有任何引用指向它的时候，它就满足垃圾回收的条件，当它被垃圾回收的时候，它的finalize()方法就会被调用
		// finalize()是由虚拟机JVM调用的
//		Parent h;
//		for (int k1 = 0; k1 < 100000; k1++) {
//            //不断生成新的对象
//            //每创建一个对象，前一个对象，就没有引用指向了
//            //那些对象，就满足垃圾回收的条件
//            //当，垃圾堆积的比较多的时候，就会触发垃圾回收
//            //一旦这个对象被回收，它的finalize()方法就会被调用
//            h = new Parent();
//        }
		// equals()用于判断两个对象的内容是否相同
		System.out.println(new Parent("jonny").equals(new Parent("xiaodan")));
		System.out.println(new Parent("jonny").equals(new Parent("jonny")));
		
		// == 用于判断两个引用，是否指向了同一个对象
		System.out.println(new Parent("xiaoduo") == new Parent("xiaoduo"));
	}
}
