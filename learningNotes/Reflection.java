/*
 * ��������е��࣬������һ��������������������ṩ�౾�����Ϣ�������м��ֹ��췽�����ж������ԣ�����Щ��ͨ������
 * ��ȡ�������3�ַ�����
 * 1��Class.forName
 * 2������.class
 * 3��new ����().getClass()
 * ��һ��JVM�У�һ����ֻ��һ���������ڡ������������ַ�ʽȡ�������������һ����
 * ׼ȷ�Ľ���һ��ClassLoader�£�һ���ֻ࣬����һ����������
 */
class RefectObj {
	public String name;
	public float hp;
	public int damage;
	public int id;

	static String copyright;
	static {
		System.out.println("��ʼ��copyright");
		copyright = "�汾��sky��˾����";
	}

	RefectObj() {
		System.out.println("Refection Object!");
	}
}

public class Reflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String className = "RefectObj";
//		try {
//			Class<?> pClass1 = Class.forName(className);
//			Class<?> pClass2 = RefectObj.class;
//			Class<?> pClass3 = new RefectObj().getClass();
//			System.out.println(pClass1 == pClass2);
//			System.out.println(pClass1 == pClass3);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		
		// ��ȡ������ʱ�򣬻ᵼ�������Ա���ʼ��
		// ����ʲô;����ȡ����󣬶��ᵼ�¾�̬���Ա���ʼ��������ֻ��ִ��һ�Ρ�������ֱ��ʹ�� Class c = Hero.class
		// ���ַ�ʽ�����ַ�ʽ���ᵼ�¾�̬���Ա���ʼ����
		try {
			Class<?> pClass4 = Class.forName(className);
			Class<?> pClass5 = RefectObj.class;
			Class<?> pClass6 = new RefectObj().getClass();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
