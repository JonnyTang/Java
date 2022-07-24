import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 * ���̼߳���ͬһʱ�䣬������������顣
 * �������߳���3�ַ�ʽ��
 * 1)�̳�Thread��
 * 2)ʵ��Runnable�ӿ�
 * 3)������ 
 * PS�������߳���start()������run()����������һ���µ��߳�
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
		System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n", name, to.name, to.name, to.hp);
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

	// ���Խ���
	public static void testProcess() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "Լ��";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "����";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "����";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "¬��";
		lunk.hp = 455;
		lunk.damage = 80;

		// Լ����������
		while (!mike.isDead()) {
			jonny.attackThreadObj(mike);
		}

		// ���ع���¬��
		while (!lunk.isDead()) {
			hunter.attackThreadObj(lunk);
		}
	}

	// ����ͨ���̳�Thread��ʵ���߳�
	public static void testThread() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "Լ��";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "����";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "����";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "¬��";
		lunk.hp = 455;
		lunk.damage = 80;

		KillThread killThread1 = new KillThread(jonny, mike);
		killThread1.start();
		KillThread killThread2 = new KillThread(hunter, lunk);
		killThread2.start();
	}

	// ����ͨ��ʵ��Runnnable�ӿ�ʵ���߳�
	public static void testRunnable() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "Լ��";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "����";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "����";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "¬��";
		lunk.hp = 455;
		lunk.damage = 80;

		Battle b1 = new Battle(jonny, mike);
		new Thread(b1).start();
		Battle b2 = new Battle(hunter, lunk);
		new Thread(b2).start();
	}

	// ����ͨ�������ഴ�����߳�
	public static void testAnonymous() {
		ThreadObj jonny = new ThreadObj();
		jonny.name = "Լ��";
		jonny.hp = 616;
		jonny.damage = 50;

		ThreadObj mike = new ThreadObj();
		mike.name = "����";
		mike.hp = 300;
		mike.damage = 30;

		ThreadObj hunter = new ThreadObj();
		hunter.name = "����";
		hunter.hp = 500;
		hunter.damage = 65;

		ThreadObj lunk = new ThreadObj();
		lunk.name = "¬��";
		lunk.hp = 455;
		lunk.damage = 80;

		// ������
		Thread t1 = new Thread() {
			public void run() {
				// ��������ʹ���ⲿ�ľֲ�����mike�������mike����Ϊfinal
				// ����JDK7�Ժ󣬾Ͳ��Ǳ����final�ˡ�
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

	// ��ϰ�����̲߳����ļ�����
	public static void multiThreadFileSearch(String path) {
		File f = new File(path);
		File[] files = f.listFiles();
		for (File fileName : files) {
			//1�����Ϊjava�ļ�������������
			if (fileName.getName().endsWith("md")) {
				System.out.println(fileName.getName());
			}
			// �������̴߳���
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
			
			//2�����Ϊ�ļ��У���������괦��
//			if (fileName.isDirectory()) {
//				multiThreadFileSearch(fileName.getAbsolutePath());
//			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Thread test!");
		/*
		 * ����(Processor)������һ��nodepad.exe����һ�����̣�������������һ��cmd.exe���ͽ���������
		 * �߳�(Thread)���߳����ڽ����ڲ�ͬʱ�������顣
		 */
		// 1����ͳ���̲�����ֻ��˳��һ����ִ��
		// testProcess();

		// 2�����̲߳���
		// testThread();
		// testRunnable();
		// testAnonymous();

		// 3����ϰ�����̲߳����ļ�����
		// ���������ļ������������ļ���.javaʱ������һ���߳�ȥ��������ļ������ݣ����صȴ�����߳̽���������������һ���ļ�
		multiThreadFileSearch("D:\\02_coding\\java_station");
	}

}
