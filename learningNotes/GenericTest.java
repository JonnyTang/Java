import java.util.ArrayList;
import java.util.LinkedList;

/*
 * ��stackջΪ���ӣ������ʹ�÷���
 * ����Ҫһ��ֻ�ܷ�Obj1ջʱ������Ҫ���һ��Obj1Stack
 * ����Ҫһ��ֻ�ܷ�Obj2ջʱ������Ҫ���һ��Obj2Stack 
 */
// ����ѧϰ
class MyStack<T> {
	LinkedList<T> values = new LinkedList<T>();

	public void push(T t) {
		values.addLast(t);
	}

	public T pull() {
		return values.removeLast();
	}

	public T peek() {
		return values.getLast();
	}
}

class Obj {
	int age = 0;
}

class Obj1 extends Obj {
	String name = "obj1";
}

class Obj2 extends Obj {
	String name = "obj2";
}

public class GenericTest {

	public static void main(String[] args) {
		// ���������Stack��ʱ��ʹ�÷���<Obj>�ͱ�ʾ��Stackֻ�ܷ�Obj
		MyStack<Obj1> obj1Stack = new MyStack<>();
		obj1Stack.push(new Obj1());
		// ���ܷ�Obj2
		// obj1Stack.push(new Obj2());

		MyStack<Obj2> obj2Stack = new MyStack<>();
		obj2Stack.push(new Obj2());

		// ����ͨ���
		// ArrayList objList<? extends Obj> ��ʾ����һ��Obj���ͻ��������෺��
		ArrayList<Obj1> obj1List = new ArrayList<Obj1>();
		obj1List.add(new Obj1());
		ArrayList<? extends Obj> objList = obj1List;
		// 1��? extends Obj ��ʾ����һ��Obj���͵����෺��

		// objList �ķ��Ϳ�����Obj
		// objList �ķ��Ϳ���ʹObj1
		// objList �ķ��Ϳ���ʹObj2

		// ����ȷ����ǣ���objListȡ�����Ķ���һ���ǿ���ת�ͳ�Obj��

		Obj h = objList.get(0);

		// ���ǣ�����������Ŷ���
		// objList.add(new Obj1()); // ���������ΪobjList�ķ��� �п�����Obj2

		// 2��?super
		// ArrayList objList<? super Obj> ��ʾ����һ��Obj���ͻ����丸�෺��
		// objList�ķ��Ϳ�����Obj��Ҳ������Object
		ArrayList<? super Obj> objlst = new ArrayList<Object>();
		// ? super Obj ��ʾ objlst�ķ�����Obj�����丸�෺��

		// objlst �ķ��Ϳ�����Obj
		// objlst �ķ��Ϳ�����Object

		// ���ԾͿ��Բ���Obj
		objlst.add(new Obj());
		// Ҳ���Բ���Hero������
		objlst.add(new Obj1());
		objlst.add(new Obj1());

		// ���ǣ����ܴ�����ȡ���ݳ���,��Ϊ�䷺�Ϳ�����Object,��Object��ǿתObj��ʧ��
		// Obj o = objlst.get(0);

		// 3������ͨ���?
		// ����ͨ������������ⷺ��
		// ��Ȼ?�������ⷺ�ͣ���ô���仰˵���������ʲô���Ͷ��п��ܣ�����ֻ����Object����ʽȡ���������Ҳ���������Ŷ�����Ϊ��֪��������һ��ʲô���͵�����
		
		/*
		���ϣ��ֻȡ���������룬��ʹ��? extends Hero
		���ϣ��ֻ���룬��ȡ������ʹ��? super Hero
		���ϣ�������ܲ��룬����ȡ�����Ͳ�Ҫ��ͨ�����
		*/
	}

}
