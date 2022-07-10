import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class ColltObj {
	String name;
	int hp;
	int j;
	ColltObj(String name, int hp, int j) {
		this.name = name;
		this.hp = hp;
		this.j = j;
	}
	
	public String getName() {
		return this.name;
	}
}


// Collections是一个类，容器的工具类，就如同Arrays是数组的工具类

public class CollectionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		// 反转
		System.out.println("集合中的数据：");
		System.out.println(numbers);

		Collections.reverse(numbers);

		System.out.println("翻转后集合中的数据");
		System.out.println(numbers);

		// shuffle混淆List中数据的顺序
		System.out.println("集合中的数据:");
		System.out.println(numbers);

		Collections.shuffle(numbers);

		System.out.println("混淆后集合中的数据:");
		System.out.println(numbers);

		// 排序后的数据
		Collections.sort(numbers);
		System.out.println("排序后集合中的数据:");
		System.out.println(numbers);
		
		// swap交互两个数据的位置
		Collections.swap(numbers,0,5);
        System.out.println("交换0和5下标的数据后，集合中的数据:");
        System.out.println(numbers);
        
        // rotate把List中的数据，向右滚动指定单位的长度
        Collections.rotate(numbers,2);
        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
        System.out.println(numbers);
        
        // 聚合操作
        Random r = new Random();
        List<ColltObj> heros = new ArrayList<ColltObj>();
        for (int i = 0; i < 10; i++) {
            heros.add(new ColltObj("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
 
        System.out.println("初始化集合后的数据 (最后一个数据重复)：");
        System.out.println(heros);
         
        //传统方式
//        Collections.sort(heros,new Comparator<ColltObj>() {
//            @Override
//            public int compare(ColltObj o1, ColltObj o2) {
//                return (int) (o2.hp-o1.hp);
//            }
//        });
//         
//        ColltObj hero = heros.get(2);
//        System.out.println("通过传统方式找出来的hp第三高的英雄名称是:" + hero.name);
         
        //聚合方式
        String name =heros
            .stream()
            .sorted((h1,h2)->h1.hp>h2.hp?-1:1)
            .skip(2)
            .map(h->h.getName())
            .findFirst()
            .get();
 
        System.out.println("通过聚合操作找出来的hp第三高的英雄名称是:" + name);
         
    }
}
