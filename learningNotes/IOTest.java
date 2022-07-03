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
		// 1.�����ļ�
		File f = new File("d:/test/test.txt");
		System.out.println("f�ľ���·����" + f.getAbsolutePath()); // ����·��
		System.out.println("��ǰ�ļ���: " + f);
		// �ļ��Ƿ����
		System.out.println("�ж��Ƿ���ڣ�" + f.exists());
		// �Ƿ����ļ���
		System.out.println("�ж��Ƿ����ļ��У� " + f.isDirectory());
		// �Ƿ����ļ�(���ļ���)
		System.out.println("�ж��Ƿ����ļ��� " + f.isFile());
		// �ļ�����
		System.out.println("��ȡ�ļ��ĳ��ȣ� " + f.length());
		// �ļ�����޸�ʱ��
		long time = f.lastModified();
		Date d = new Date(time);
		System.out.println("��ȡ�ļ�������޸�ʱ�䣺" + d);
		// �����ļ��޸�ʱ��Ϊ1970.1.1 08:00:00
		f.setLastModified(0);

		// �ļ�������
		File f2 = new File("d:/test/tt.txt");
		f.renameTo(f2);
		System.out.println("��test.txt��������tt.txt");

		System.out.println("ע�⣺ ��Ҫ��D:\\testȷʵ����һ��test.txt,\r\n�ſ��Կ�����Ӧ���ļ����ȡ��޸�ʱ�����Ϣ");

		File f3 = new File("D:\\02_coding");
		// ���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ�(���������ļ������ļ���)
		f3.list();
		// ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ�(���������ļ������ļ���)
		File[] fs = f3.listFiles();
		System.out.println(fs[0].getAbsolutePath());
		// ���ַ�����ʽ���ػ�ȡ�����ļ���
		System.out.println(f3.getParent());
		// ���ļ���ʽ���ػ�ȡ�����ļ���
		System.out.println(f3.getParentFile().getName());
		// �г����е���c: d: e: �ȵ�
		System.out.println(File.listRoots()[0]);
	}

	private static void testByteStream() {
		try {
			File f = new File("D:\\test.txt");
			try (// ���������ļ���������
					FileInputStream fis = new FileInputStream(f)) {
				// �����ֽ����飬�䳤�Ⱦ����ļ��ĳ���
				byte[] all = new byte[(int) f.length()];
				// ���ֽ�������ʽ��ȡ�ļ���������
				fis.read(all);
				for (byte b : all) {
					System.out.println(b);
				}
				// ÿ��ʹ����������Ӧ�ùر�
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * InputStream �ֽ������� FileInputStream��InputStream���� OutputStream
		 * �ֽ��������ͬʱҲ�ǳ����࣬FileOutputStream���������� �������ֽڵ���ʽ��ȡ��д������
		 */
		try {
			File f1 = new File("D:\\test.txt");
			byte data[] = { 88, 89 }; // �ֱ��Ӧ�ַ�X,Y
			FileOutputStream fos = new FileOutputStream(f1);
			fos.write(data);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testStrReaderWriter() {
		File f = new File("D:\\test.txt");
		// д�ļ�
		try (FileWriter fw = new FileWriter(f)) {
			String data = "this is a hero";
			char[] cs = data.toCharArray();
			fw.write(cs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// ���ļ�
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
		String str = "����";
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
			System.out.printf("�ַ���\"%s\" �ڱ��뷽ʽ%s�µ�ʮ������ֵ��%n", str, encode);
			byte[] bs = str.getBytes(encode);
			for (byte b : bs) {
				int i = b & 0xff;
				System.out.print(Integer.toHexString(i) + "\t");
			}
			System.out.println();
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			System.out.printf("UnsupportedEncodingException: %s���뷽ʽ�޷������ַ�%s\n", encode, str);
		}
	}

	private static void testZhongwen1() {
		File f = new File("D:\\test.txt");
		try (FileInputStream fis = new FileInputStream(f);) {
			byte[] all = new byte[(int) f.length()];
			fis.read(all);

			// �ļ��ж�������������
			System.out.println("�ļ��ж������������ǣ�");
			for (byte b : all) {
				int i = b & 0x000000ff; // ֻȡ16���Ƶĺ���λ
				System.out.println(Integer.toHexString(i));
			}
			System.out.println("���������ת��GBK����");
			String str = new String(all, "GBK");
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("I/O���ѧϰ");
		System.out.println("===========");
		// 1. �ļ�����
		// testFile();

		// 2.��������һϵ�е�����
		// testByteStream();

		// 3.�ַ���
		// Reader�ַ���������Writer�ַ������ ר�������ַ�����ʽ��ȡ��д������
		// testStrReaderWriter();

		// 4.��������
		/*
		 * ISO-8859-1 ASCII ���ֺ���ŷ��ĸ GB2312 BIG5 GBK ���ģ�GB2312
		 * �Ǽ������ģ�BIG5�Ƿ������ģ�GBKͬʱ��������ͷ����Լ����ġ� UNICODE
		 * (ͳһ�룬�����)�����������е����֣��������ģ�Ӣ�ģ����ģ����ģ��������е����ֶ��������С�UTF-8�Ƕ����ֺ���ĸ
		 * ʹ��һ���ֽڣ����Ժ��־�ʹ��3���ֽڣ��Ӷ��ﵽ�����ʡ���Ч����
		 */
		// testZhongwen();
		testZhongwen1();

	}

}
