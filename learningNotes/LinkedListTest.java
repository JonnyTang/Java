import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LinkedObj {
	String name;

	LinkedObj(String name) {
		this.name = name;
		System.out.println("this obj'name is " + this.name);
	}
}

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("LinkedListѧϰ");
		/*
		 * ���з��Ƚ��ȳ�FIFO���Ƚ����FILO��ǰ�߽�Queue���У������ֽ���Stackջ
		 */
		// LinkedList��һ��˫������ṹ��list
//		LinkedList<LinkedObj> ll = new LinkedList<LinkedObj>();
//		// ��ͷ����β����������
//		ll.addLast(new LinkedObj("jonny"));
//		ll.addLast(new LinkedObj("mike"));
//		ll.addLast(new LinkedObj("scott"));
//		System.out.println(ll);
//		
//		ll.addFirst(new LinkedObj("lily"));
//		System.out.println(ll);
//		
//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
//		
//		//ɾ��
//		System.out.println(ll);
//		System.out.println(ll.removeFirst());
//		System.out.println(ll.removeLast());
//		System.out.println(ll);
		// ��ArrayListһ����LinkedListҲʵ����List�ӿ�
		List ll = new LinkedList<Animal>();
		Queue<Animal> q = new LinkedList<Animal>();
		
		System.out.print("��ʼ�����У� \t");
		q.offer(new Animal("dog"));
		q.offer(new Animal("cat"));
		q.offer(new Animal("bird"));
		q.offer(new Animal("oxe"));
		
		System.out.println(q);
		System.out.print("�ѵ�һ��Ԫ��ȡpoll()����:\t");
		Animal a = q.poll();
		System.out.println(a);
		System.out.print("ȡ����һ��Ԫ��֮��Ķ���:\t");
		System.out.println(q);
		// �ѵ�һ���ó�����һ�������ǲ�ȡ����
		a = q.peek();
		System.out.print("�鿴peek()��һ��Ԫ��:\t");
		System.out.println(a);
		System.out.print("�鿴�����ᵼ�µ�һ��Ԫ�ر�ȡ������\t");
		System.out.println(q);
	}

}
