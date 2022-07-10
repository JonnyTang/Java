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


// Collections��һ���࣬�����Ĺ����࣬����ͬArrays������Ĺ�����

public class CollectionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			numbers.add(i);
		}

		// ��ת
		System.out.println("�����е����ݣ�");
		System.out.println(numbers);

		Collections.reverse(numbers);

		System.out.println("��ת�󼯺��е�����");
		System.out.println(numbers);

		// shuffle����List�����ݵ�˳��
		System.out.println("�����е�����:");
		System.out.println(numbers);

		Collections.shuffle(numbers);

		System.out.println("�����󼯺��е�����:");
		System.out.println(numbers);

		// ����������
		Collections.sort(numbers);
		System.out.println("����󼯺��е�����:");
		System.out.println(numbers);
		
		// swap�����������ݵ�λ��
		Collections.swap(numbers,0,5);
        System.out.println("����0��5�±�����ݺ󣬼����е�����:");
        System.out.println(numbers);
        
        // rotate��List�е����ݣ����ҹ���ָ����λ�ĳ���
        Collections.rotate(numbers,2);
        System.out.println("�Ѽ������ҹ���2����λ��������ݺ󣬼����е�����:");
        System.out.println(numbers);
        
        // �ۺϲ���
        Random r = new Random();
        List<ColltObj> heros = new ArrayList<ColltObj>();
        for (int i = 0; i < 10; i++) {
            heros.add(new ColltObj("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
 
        System.out.println("��ʼ�����Ϻ������ (���һ�������ظ�)��");
        System.out.println(heros);
         
        //��ͳ��ʽ
//        Collections.sort(heros,new Comparator<ColltObj>() {
//            @Override
//            public int compare(ColltObj o1, ColltObj o2) {
//                return (int) (o2.hp-o1.hp);
//            }
//        });
//         
//        ColltObj hero = heros.get(2);
//        System.out.println("ͨ����ͳ��ʽ�ҳ�����hp�����ߵ�Ӣ��������:" + hero.name);
         
        //�ۺϷ�ʽ
        String name =heros
            .stream()
            .sorted((h1,h2)->h1.hp>h2.hp?-1:1)
            .skip(2)
            .map(h->h.getName())
            .findFirst()
            .get();
 
        System.out.println("ͨ���ۺϲ����ҳ�����hp�����ߵ�Ӣ��������:" + name);
         
    }
}
