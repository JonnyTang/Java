import java.util.ArrayList;
import java.util.Random;
import java.util.List;

class LamdbaObj {
	String name;
	int age;
	int high;
	
	LamdbaObj(String name, int age, int high) {
		this.name = name;
		this.age = age;
		this.high = high;
	}
	
	@Override
	public String toString() {
		return this.name + " " + this.age + " " + this.high;
	}
}

interface LamObjChecker {
    public boolean test(LamdbaObj h);
}

public class Lamdba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("learning lamdba!");
		Random r = new Random();
		List<LamdbaObj> lams = new ArrayList<LamdbaObj>();
		for (int i = 0; i < 5; i++) {
			lams.add(new LamdbaObj("lam " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("初始化后的集合： ");
		System.out.println(lams);
		System.out.println("使用Lamdba的方式，筛选出 age > 100 && high < 50 的lamdba测试对象");
		filter(lams, h->h.age > 100 && h.high < 50);
	}
	
	private static void filter(List<LamdbaObj> lams, LamObjChecker checker) {
		for (LamdbaObj obj : lams) {
			if (checker.test(obj)) {
				System.out.println(obj);
			}
		}
	}
}
