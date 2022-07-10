import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class HashObj {
	String name;

	HashObj(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}

// HashMap储存数据的方式是——键值对
public class HashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> dic = new HashMap<>();
		dic.put("jonny", "dog");
		dic.put("scott", "cat");
		dic.put("mike", "bird");

		System.out.println(dic.get("jonny"));

		HashMap<String, HashObj> mp = new HashMap<String, HashObj>();
		mp.put("red", new HashObj("watermelon"));
		System.out.println(mp);
		// 清空map
		mp.clear();
		HashObj ho = new HashObj("apple");
		mp.put("green", ho);
		mp.put("red", ho);

		System.out.println(mp);

		// set中元素不能重复
		HashSet<String> names = new HashSet<String>();
		names.add("jonny");
		System.out.println(names);
		// 再插入一个，容器中只会保留一个
		names.add("jonny");
		System.out.println(names);
		// 没有顺序
		HashSet<Integer> numbers = new HashSet<Integer>();
		numbers.add(9);
		numbers.add(5);
		numbers.add(1);
		System.out.println(numbers);

		// 遍历
		for (int i = 0; i < 20; i++) {
			numbers.add(i);
		}

		for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();) {
			Integer i = (Integer) iterator.next();
			System.out.println(i);
		}

		for (Integer i : numbers) {
			System.out.println(i);
		}
	}
}
