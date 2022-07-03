import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class IOTest {

	private static void testFile() {
		// 1.操作文件
		File f = new File("d:/test/test.txt");
		System.out.println("f的绝对路径：" + f.getAbsolutePath()); // 绝对路径
		System.out.println("当前文件是: " + f);
		// 文件是否存在
		System.out.println("判断是否存在：" + f.exists());
		// 是否是文件夹
		System.out.println("判断是否是文件夹： " + f.isDirectory());
		// 是否是文件(非文件夹)
		System.out.println("判断是否是文件： " + f.isFile());
		// 文件长度
		System.out.println("获取文件的长度： " + f.length());
		// 文件最后修改时间
		long time = f.lastModified();
		Date d = new Date(time);
		System.out.println("获取文件的最后修改时间：" + d);
		// 设置文件修改时间为1970.1.1 08:00:00
		f.setLastModified(0);

		// 文件重命名
		File f2 = new File("d:/test/tt.txt");
		f.renameTo(f2);
		System.out.println("把test.txt改名成了tt.txt");

		System.out.println("注意： 需要在D:\\test确实存在一个test.txt,\r\n才可以看到对应的文件长度、修改时间等信息");

		File f3 = new File("D:\\02_coding");
		// 以字符串数组的形式，返回当前文件夹下的所有文件(不包含子文件及子文件夹)
		f3.list();
		// 以文件数组的形式，返回当前文件夹下的所有文件(不包含子文件及子文件夹)
		File[] fs = f3.listFiles();
		System.out.println(fs[0].getAbsolutePath());
		// 以字符串形式返回获取所在文件夹
		System.out.println(f3.getParent());
		// 以文件形式返回获取所在文件夹
		System.out.println(f3.getParentFile().getName());
		// 列出所有的盘c: d: e: 等等
		System.out.println(File.listRoots()[0]);
	}

	private static void testByteStream() {
		try {
			File f = new File("D:\\test.txt");
			try (// 创建基于文件的输入流
					FileInputStream fis = new FileInputStream(f)) {
				// 创建字节数组，其长度就是文件的长度
				byte[] all = new byte[(int) f.length()];
				// 以字节流的形式读取文件所有内容
				fis.read(all);
				for (byte b : all) {
					System.out.println(b);
				}
				// 每次使用完流，都应该关闭
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * InputStream 字节输入流 FileInputStream是InputStream子类 OutputStream
		 * 字节输出流，同时也是抽象类，FileOutputStream是它的子类 用于以字节的形式读取和写入数据
		 */
		try {
			File f1 = new File("D:\\test.txt");
			byte data[] = { 88, 89 }; // 分别对应字符X,Y
			FileOutputStream fos = new FileOutputStream(f1);
			fos.write(data);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testStrReaderWriter() {
		File f = new File("D:\\test.txt");
		// 写文件
		try (FileWriter fw = new FileWriter(f)) {
			String data = "this is a hero";
			char[] cs = data.toCharArray();
			fw.write(cs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// 读文件
		try (FileReader fr = new FileReader(f)) {
			char[] all = new char[(int) f.length()];
			fr.read(all);
			for (char b : all) {
				System.out.print(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void testZhongwen() {
		String str = "中文";
		showCode(str);
	}

	private static void showCode(String str) {
		String[] encodes = { "GB2312", "BIG5", "GBK", "UTF-8", "UTF-16", "UTF-32" };
		for (String encode : encodes) {
			showCode(str, encode);
		}
	}

	private static void showCode(String str, String encode) {
		try {
			System.out.printf("字符：\"%s\" 在编码方式%s下的十六进制值是%n", str, encode);
			byte[] bs = str.getBytes(encode);
			for (byte b : bs) {
				int i = b & 0xff;
				System.out.print(Integer.toHexString(i) + "\t");
			}
			System.out.println();
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
		}
	}

	private static void testZhongwen1() {
		File f = new File("D:\\test.txt");
		try (FileInputStream fis = new FileInputStream(f);) {
			byte[] all = new byte[(int) f.length()];
			fis.read(all);

			// 文件中读出来的数据是
			System.out.println("文件中读出来的数据是：");
			for (byte b : all) {
				int i = b & 0x000000ff; // 只取16进制的后两位
				System.out.println(Integer.toHexString(i));
			}
			System.out.println("把这个数字转成GBK编码");
			String str = new String(all, "GBK");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("I/O相关学习");
		System.out.println("===========");
		// 1. 文件操作
		// testFile();

		// 2.流：就是一系列的数据
		// testByteStream();

		// 3.字符流
		// Reader字符输入流、Writer字符输出流 专门用于字符的形式读取和写入数据
		// testStrReaderWriter();

		// 4.中文问题
		/*
		 * ISO-8859-1 ASCII 数字和西欧字母 GB2312 BIG5 GBK 中文：GB2312
		 * 是简体中文，BIG5是繁体中文，GBK同时包含简体和繁体以及日文。 UNICODE
		 * (统一码，万国码)：包括了所有的文字，无论中文，英文，藏文，法文，世界所有的文字都包含其中。UTF-8是对数字和字母
		 * 使用一个字节，而对汉字就使用3个字节，从而达到“减肥”的效果。
		 */
		// testZhongwen();
		testZhongwen1();

	}

}
