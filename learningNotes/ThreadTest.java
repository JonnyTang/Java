import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * 多线程即在同一时间，可以做多件事情。
 * 创建多线程有3种方式：
 * 1)继承Thread类
 * 2)实现Runnable接口
 * 3)匿名类 
 * PS：启动线程是start()方法，run()并不能启动一个新的线程
 */

class ThreadObj {
	public String name;
	public float hp;

	public int damage;

	public void attackThreadObj(ThreadObj to) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		to.hp -= damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n", name, to.name, to.name, to.hp);
	}

	public boolean isDead() {
		return 0 >= hp ? true : false;
	}
}

class KillThread extends Thread {
	private ThreadObj t1;
	private ThreadObj t2;

	public KillThread(ThreadObj t1, ThreadObj t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public void run() {
		while (!t2.isDead()) {
			t1.attackThreadObj(t2);
		}
	}
}

class Battle implements Runnable {
	private ThreadObj t1;
	private ThreadObj t2;

	public Battle(ThreadObj t1, ThreadObj t2) {
		this.t1 = t1;
		this.t2 = t2;
	}

	public void run() {
		while (!t2.isDead()) {
			t1.attackThreadObj(t2);
		}
	}
}

public class ThreadTest {

	// 测试进程
	public static void testProcess() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "约翰";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "迈克";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "亨特";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "卢克";
		lunk.hp = 455;
		lunk.damage = 80;

		// 约翰攻击迈克
		while (!mike.isDead()) {
			jonny.attackThreadObj(mike);
		}

		// 亨特攻击卢克
		while (!lunk.isDead()) {
			hunter.attackThreadObj(lunk);
		}
	}

	// 测试通过继承Thread类实现线程
	public static void testThread() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "约翰";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "迈克";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "亨特";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "卢克";
		lunk.hp = 455;
		lunk.damage = 80;

		KillThread killThread1 = new KillThread(jonny, mike);
		killThread1.start();
		KillThread killThread2 = new KillThread(hunter, lunk);
		killThread2.start();
	}

	// 测试通过实现Runnnable接口实现线程
	public static void testRunnable() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "约翰";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "迈克";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "亨特";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "卢克";
		lunk.hp = 455;
		lunk.damage = 80;

		Battle b1 = new Battle(jonny, mike);
		new Thread(b1).start();
		Battle b2 = new Battle(hunter, lunk);
		new Thread(b2).start();
	}

	// 测试通过匿名类创建多线程
	public static void testAnonymous() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "约翰";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "迈克";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "亨特";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "卢克";
		lunk.hp = 455;
		lunk.damage = 80;

		// 匿名类
		Thread t1 = new Thread() {
			public void run() {
				// 匿名类中使用外部的局部变量mike，必须把mike声明为final
				// 但在JDK7以后，就不是必须加final了。
				while (!mike.isDead()) {
					jonny.attackThreadObj(mike);
				}
			}
		};
		t1.start();

		Thread t2 = new Thread() {
			public void run() {
				while (!lunk.isDead()) {
					hunter.attackThreadObj(lunk);
				}
			}
		};
		t2.start();
	}

	// 练习：多线程查找文件内容
	public static void multiThreadFileSearch(String path) {
		File f = new File(path);
		File[] files = f.listFiles();
		for (File fileName : files) {
			//1、如果为java文件，则搜索内容
			if (fileName.getName().endsWith("md")) {
				System.out.println(fileName.getName());
			}
			// 创建多线程处理
			Thread t = new Thread() {
				public void run() {
					try {
						FileReader fr = new FileReader(fileName);
					} catch(FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			};
			t.start();
			
			//2、如果为文件夹，则继续下钻处理
//			if (fileName.isDirectory()) {
//				multiThreadFileSearch(fileName.getAbsolutePath());
//			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Thread test!");
		/*
		 * 进程(Processor)：启动一个nodepad.exe就是一个进程，接着又启动另一个cmd.exe，就叫两个进程
		 * 线程(Thread)：线程是在进程内部同时做的事情。
		 */
		// 1、传统进程操作，只能顺序一个个执行
		// testProcess();

		// 2、多线程操作
		// testThread();
		// testRunnable();
		// testAnonymous();

		// 3、练习：多线程查找文件内容
		// 遍历所有文件，当遍历到文件是.java时，创建一个线程去查找这个文件的内容，不必等待这个线程结束，继续遍历下一个文件
		multiThreadFileSearch("D:\\02_coding\\java_station");
	}

}
