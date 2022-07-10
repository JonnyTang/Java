import java.util.ArrayList;
import java.util.LinkedList;

/*
 * 以stack栈为例子，如果不使用泛型
 * 当需要一个只能放Obj1栈时，就需要设计一个Obj1Stack
 * 当需要一个只能放Obj2栈时，就需要设计一个Obj2Stack 
 */
// 泛型学习
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
		// 在声明这个Stack的时候，使用泛型<Obj>就表示该Stack只能放Obj
		MyStack<Obj1> obj1Stack = new MyStack<>();
		obj1Stack.push(new Obj1());
		// 不能放Obj2
		// obj1Stack.push(new Obj2());

		MyStack<Obj2> obj2Stack = new MyStack<>();
		obj2Stack.push(new Obj2());

		// 泛型通配符
		// ArrayList objList<? extends Obj> 表示这是一个Obj泛型或者其子类泛型
		ArrayList<Obj1> obj1List = new ArrayList<Obj1>();
		obj1List.add(new Obj1());
		ArrayList<? extends Obj> objList = obj1List;
		// 1）? extends Obj 表示这是一个Obj泛型的子类泛型

		// objList 的泛型可以是Obj
		// objList 的泛型可以使Obj1
		// objList 的泛型可以使Obj2

		// 可以确凿的是，从objList取出来的对象，一定是可以转型成Obj的

		Obj h = objList.get(0);

		// 但是，不能往里面放东西
		// objList.add(new Obj1()); // 编译错误，因为objList的泛型 有可能是Obj2

		// 2）?super
		// ArrayList objList<? super Obj> 表示这是一个Obj泛型或者其父类泛型
		// objList的泛型可能是Obj，也可能是Object
		ArrayList<? super Obj> objlst = new ArrayList<Object>();
		// ? super Obj 表示 objlst的泛型是Obj或者其父类泛型

		// objlst 的泛型可以是Obj
		// objlst 的泛型可以是Object

		// 所以就可以插入Obj
		objlst.add(new Obj());
		// 也可以插入Hero的子类
		objlst.add(new Obj1());
		objlst.add(new Obj1());

		// 但是，不能从里面取数据出来,因为其泛型可能是Object,而Object是强转Obj会失败
		// Obj o = objlst.get(0);

		// 3）泛型通配符?
		// 泛型通配符？代表任意泛型
		// 既然?代表任意泛型，那么换句话说，这个容器什么泛型都有可能，所以只能以Object的形式取出来，并且不能往里面放对象，因为不知道到底是一个什么泛型的容器
		
		/*
		如果希望只取出，不插入，就使用? extends Hero
		如果希望只插入，不取出，就使用? super Hero
		如果希望，又能插入，又能取出，就不要用通配符？
		*/
	}

}
