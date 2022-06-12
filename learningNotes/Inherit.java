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
		Child c = new Child();
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
	}
}
