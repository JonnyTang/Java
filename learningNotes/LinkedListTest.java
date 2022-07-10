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
		System.out.println("LinkedList学习");
		/*
		 * 序列分先进先出FIFO，先进后出FILO，前者叫Queue队列，后者又叫做Stack栈
		 */
		// LinkedList是一个双向链表结构的list
//		LinkedList<LinkedObj> ll = new LinkedList<LinkedObj>();
//		// 在头部、尾部插入数据
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
//		//删除
//		System.out.println(ll);
//		System.out.println(ll.removeFirst());
//		System.out.println(ll.removeLast());
//		System.out.println(ll);
		// 和ArrayList一样，LinkedList也实现了List接口
		List ll = new LinkedList<Animal>();
		Queue<Animal> q = new LinkedList<Animal>();
		
		System.out.print("初始化队列： \t");
		q.offer(new Animal("dog"));
		q.offer(new Animal("cat"));
		q.offer(new Animal("bird"));
		q.offer(new Animal("oxe"));
		
		System.out.println(q);
		System.out.print("把第一个元素取poll()出来:\t");
		Animal a = q.poll();
		System.out.println(a);
		System.out.print("取出第一个元素之后的队列:\t");
		System.out.println(q);
		// 把第一个拿出来看一看，但是不取出来
		a = q.peek();
		System.out.print("查看peek()第一个元素:\t");
		System.out.println(a);
		System.out.print("查看并不会导致第一个元素被取出来：\t");
		System.out.println(q);
	}

}
