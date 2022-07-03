import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionTest {
	
	private static void test() throws FileNotFoundException {
		System.out.println("异常处理");
		File f = new File("d:/JT.exe");
		new FileInputStream(f);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 试图打开JT.exe，会抛出FileNotFoundException.
		try {
			System.out.println("试图打开JT.exe");
			test();
			System.out.println("打开文件成功！");
		} catch (FileNotFoundException e) { // 也可以使用其父类Exception
			// TODO Auto-generated catch block
			System.out.println("JT.exe文件不存在！");
			e.printStackTrace();
		} finally {
			System.out.println("无论文件存不存在，都会执行！");
		}
		/*
		 * throws与throw这两个关键字接近，不过意义不一样，有如下区别：
		 * 1. throws 出现在方法声明上，而throw通常都出现在方法体内。
		 * 2. throws 表示出现异常的一种可能性，并不一定会发生这些异常；throw则是抛出了异常，执行throw则一定抛出了某个异常对象。
		 * */
		/*
		 * 1、可查异常CheckedException，即必须进行处理的异常，要么try catch住，谁调用，谁处理，
		 * 比如FileNotFoundException，如果不处理，编译器，就不让通过。
		 * 2、运行时异常RuntimeException：不是必须进行try catch的异常。
		 * 常见：除数不能为0异常：ArithmeticException; 下标越界异常：ArrayIndexOutOfBoundsException;
		 * 空指针异常：NullPointerException
		 * 3、错误Error，指的是系统级别的异常，通常是内存用光了。在默认设置下，一般JAVA程序启动的时候，最大可以使用16m的内存
		 * 如不停的给StringBuffer追加字符，很快就把内存使用光了。抛出OutOfMemoryError.
		 * 与运行时异常一样，错误也是不要求强制捕捉的。
		 * */
		/*
		 * Throwable是类，Exception和Error都继承了该类，所以在捕捉的时候，也可以使用Throwable进行捕捉
		 * */
	}

}

// 自定义异常
class MyException extends Exception {
	public MyException() {
		
	}
	
	public MyException(String msg) {
		super(msg);
	}
}
