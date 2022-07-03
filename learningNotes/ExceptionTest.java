import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
	
	private static void test() throws FileNotFoundException {
		System.out.println("�쳣����");
		File f = new File("d:/JT.exe");
		new FileInputStream(f);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ��ͼ��JT.exe�����׳�FileNotFoundException.
		try {
			System.out.println("��ͼ��JT.exe");
			test();
			System.out.println("���ļ��ɹ���");
		} catch (FileNotFoundException e) { // Ҳ����ʹ���丸��Exception
			// TODO Auto-generated catch block
			System.out.println("JT.exe�ļ������ڣ�");
			e.printStackTrace();
		} finally {
			System.out.println("�����ļ��治���ڣ�����ִ�У�");
		}
		/*
		 * throws��throw�������ؼ��ֽӽ����������岻һ��������������
		 * 1. throws �����ڷ��������ϣ���throwͨ���������ڷ������ڡ�
		 * 2. throws ��ʾ�����쳣��һ�ֿ����ԣ�����һ���ᷢ����Щ�쳣��throw�����׳����쳣��ִ��throw��һ���׳���ĳ���쳣����
		 * */
		/*
		 * 1���ɲ��쳣CheckedException����������д�����쳣��Ҫôtry catchס��˭���ã�˭����
		 * ����FileNotFoundException��������������������Ͳ���ͨ����
		 * 2������ʱ�쳣RuntimeException�����Ǳ������try catch���쳣��
		 * ��������������Ϊ0�쳣��ArithmeticException; �±�Խ���쳣��ArrayIndexOutOfBoundsException;
		 * ��ָ���쳣��NullPointerException
		 * 3������Error��ָ����ϵͳ������쳣��ͨ�����ڴ��ù��ˡ���Ĭ�������£�һ��JAVA����������ʱ��������ʹ��16m���ڴ�
		 * �粻ͣ�ĸ�StringBuffer׷���ַ����ܿ�Ͱ��ڴ�ʹ�ù��ˡ��׳�OutOfMemoryError.
		 * ������ʱ�쳣һ��������Ҳ�ǲ�Ҫ��ǿ�Ʋ�׽�ġ�
		 * */
		/*
		 * Throwable���࣬Exception��Error���̳��˸��࣬�����ڲ�׽��ʱ��Ҳ����ʹ��Throwable���в�׽
		 * */
	}

}

// �Զ����쳣
class MyException extends Exception {
	public MyException() {
		
	}
	
	public MyException(String msg) {
		super(msg);
	}
}
