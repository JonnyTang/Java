import java.util.Scanner;

/**
 * @author jonny
 *
 */
public class InOut {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
    //1. 输出
    System.out.print("this is system out and in ");
    System.out.println("with enter.");
    
    
    //2. 输入
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();  // 可以有不同的接收类型
		System.out.println("第一个整数：" + a);
		int b = s.nextInt();
		System.out.println("第二个整数：" + b);
		s.close();
	}
}
