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
		System.out.println("-----集合学习-----");
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("dog"));
		System.out.println(animals.size());
		
		// 容器的容量capacity随着对象的增加，自动增长
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
		// 获取指定位置
		System.out.println(animals.get(3).getName());
		// 判断一个对象在ArrayList中所处的位置
		System.out.println(animals.indexOf(animals.get(3)));
		// 删除一个对象
		System.out.println(animals.get(2).getName());
		animals.remove(2);
		System.out.println(animals.get(2).getName());
		// 替换对象
		System.out.println(animals.get(1).getName());
		animals.set(1, new Animal("bear"));
		System.out.println(animals.get(1).getName());
		// 转换成数组
		Animal ans[] = (Animal[])animals.toArray(new Animal[] {});
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i].getName());
		}
		
		// 三种循环方式
		System.out.println("----------for循环------------");
		for (int k = 0; k < animals.size(); k++) {
			System.out.println(animals.get(k).getName());
		}
		
		System.out.println("----------使用while的iteraator----------");
		Iterator<Animal> it = animals.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getName());
		}
		
		System.out.println("----------使用for的iterator-------------");
		for (Iterator<Animal> iterator = animals.iterator(); iterator.hasNext();) {
			System.out.println(((Animal)iterator.next()).getName());
		}
		
		System.out.println("----------增强型for循环----------");
		for (Animal a : animals) {
			System.out.println(a.getName());
		}
	}

}
