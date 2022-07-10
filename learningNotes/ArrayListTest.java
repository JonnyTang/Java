import java.util.ArrayList;
import java.util.Iterator;

class Animal {
	String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}

public class ArrayListTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----����ѧϰ-----");
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("dog"));
		System.out.println(animals.size());
		
		// ����������capacity���Ŷ�������ӣ��Զ�����
		animals.add(new Animal("cat"));
		System.out.println(animals.size());
		
		animals.add(new Animal("bird"));
		animals.add(new Animal("horse"));
		animals.add(new Animal("chiken"));
		animals.add(new Animal("fish"));
		System.out.println(animals.size());
		System.out.println(animals.contains(new Animal("dog")));
		Animal fox = new Animal("fox");
		animals.add(fox);
		System.out.println(animals.contains(fox));
		// ��ȡָ��λ��
		System.out.println(animals.get(3).getName());
		// �ж�һ��������ArrayList��������λ��
		System.out.println(animals.indexOf(animals.get(3)));
		// ɾ��һ������
		System.out.println(animals.get(2).getName());
		animals.remove(2);
		System.out.println(animals.get(2).getName());
		// �滻����
		System.out.println(animals.get(1).getName());
		animals.set(1, new Animal("bear"));
		System.out.println(animals.get(1).getName());
		// ת��������
		Animal ans[] = (Animal[])animals.toArray(new Animal[] {});
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i].getName());
		}
		
		// ����ѭ����ʽ
		System.out.println("----------forѭ��------------");
		for (int k = 0; k < animals.size(); k++) {
			System.out.println(animals.get(k).getName());
		}
		
		System.out.println("----------ʹ��while��iteraator----------");
		Iterator<Animal> it = animals.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}
		
		System.out.println("----------ʹ��for��iterator-------------");
		for (Iterator<Animal> iterator = animals.iterator(); iterator.hasNext();) {
			System.out.println(((Animal)iterator.next()).getName());
		}
		
		System.out.println("----------��ǿ��forѭ��----------");
		for (Animal a : animals) {
			System.out.println(a.getName());
		}
	}

}
