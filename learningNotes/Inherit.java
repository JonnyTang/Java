// 1���ӿڣ�����һ��Լ���� ʵ��ĳ���ӿڣ����൱�ڳ�ŵ��ĳ��Լ��
// ��Ҫ��publicԼ������Ȼ��ҪŪ�ɵ����ļ�
interface Flyer {
	public void fly();
}

class Bird implements Flyer {
	@Override
	public void fly() {
		System.out.println("I'm a bird, I can fly!");
	}
}

// 2������ת��
// ����
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

	// �вι�������
	public Parent(String name) {
		System.out.println("This is Parent's constructor with params��");
		this.name = name;
	}

	public void finalize() {
		System.out.println("����������ڱ�����");
	}
	
	public boolean equals(Object o) {
		if (o instanceof Parent) {
			Parent p = (Parent)o;
			return this.name == p.name;
		}
		return false;
	}
}

// ����
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

	// �вι�������
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
		System.out.println("�ӿںͼ̳У�����");

		// 1���ӿ�
		Bird b = new Bird();
		b.fly();

		// 2������ת��
		// 2.1 ����ת������������ת���ɸ����ǿ���ͨ��
		Parent p = new Parent();
		Child c = new Child(); // ����ʵ��ʱ������Ҳ��ʵ�������乹�������ᱻ����
		p = c;
		p.say();
		// 2.2 ����ת��������ת�������࣬��һ����ǿ��ת��������Ը�
//		c = (Child) p;
//		c.say();
		// 2.3 ����û�м̳й�ϵ���಻��ת��
		Child c1 = new Child();
		Child1 c2 = new Child1();
//		c1 = (Child)c2;  // ����ֱ������
		c1.say();
		c2.say();
		// 2.4 ������ת�ɽӿ�
		Bird b1 = new Bird();
		Flyer f = b1; // Bird��ʵ���˽ӿ�
		f.fly();

		// �ж϶����Ƿ�Ϊĳ����
		System.out.println(b1 instanceof Bird);

		// 3. ��д
		// ������Լ̳и���Ķ��󷽷����ڼ̳к��ظ��ṩ�÷������ͽ�����������д���ֽи���override
		System.out.println("override!!!");
		Parent p2 = new Parent();
		Child c3 = new Child();
		p2.say();
		c3.say();

		// 4. ��̬
		// �������Ķ�̬��+������Ϊ�������㣬Ҳ������Ϊ�ַ������ӣ�
		// ��Ķ�̬����������ָ���������
		/*
		 * ʵ����Ķ�̬����Ҫ���������� 1�������ӿ�����ָ��������� 2�����õķ�������д
		 */
		int i = 2;
		int j = 3;
		int k = i + j; // ���+�����඼����������ô+�����������
		System.out.println(k);

		int a = 5;
		String str1 = "5";
		String str = a + str1; // ���+���࣬������һ�����ַ�������+�����ַ�������
		System.out.println(str);

		// 5. ����
		// ���ؾ������า�Ǹ�����෽��
		Parent.dance();
		Child.dance();

		// 6. super
		new Parent("Jonny");
		new Child("xiaoduo");

		// 7. Object�࣬Object��������������ࡣ����һ�����ʱ��Ĭ���Ǽ̳���Object
		Parent dan = new Parent("xiaodan");
		System.out.println(dan.toString());
		// ��һ������û���κ�����ָ������ʱ�����������������յ��������������������յ�ʱ������finalize()�����ͻᱻ����
		// finalize()���������JVM���õ�
//		Parent h;
//		for (int k1 = 0; k1 < 100000; k1++) {
//            //���������µĶ���
//            //ÿ����һ������ǰһ�����󣬾�û������ָ����
//            //��Щ���󣬾������������յ�����
//            //���������ѻ��ıȽ϶��ʱ�򣬾ͻᴥ����������
//            //һ��������󱻻��գ�����finalize()�����ͻᱻ����
//            h = new Parent();
//        }
		// equals()�����ж���������������Ƿ���ͬ
		System.out.println(new Parent("jonny").equals(new Parent("xiaodan")));
		System.out.println(new Parent("jonny").equals(new Parent("jonny")));
		
		// == �����ж��������ã��Ƿ�ָ����ͬһ������
		System.out.println(new Parent("xiaoduo") == new Parent("xiaoduo"));
	}
}
