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
		// 1. ���
		System.out.println("�����������");
		System.out.print("�����������.");

		// 2. ����
		Scanner s = new Scanner(System.in);
		int a = s.nextInt(); // �����в�ͬ�Ľ�������
		System.out.println("��һ��������" + a);
		int b = s.nextInt();
		System.out.println("�ڶ���������" + b);
		s.close();
	}
}
