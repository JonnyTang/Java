
public class Strnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ֺ��ַ�����");
		
		//1.��װ�ࣺ���л������ͣ����ж�Ӧ�������ͣ�������ͽ�����װ�ࡣ����int��Ӧ������Integer
		int i = 100;
		Integer it = new Integer(i);
		int i2 = it.intValue();
		System.out.println(i2);
		// ���ַ�װ����Byte,Short,Integer,Long,Float,Double����Щ�඼�ǳ�����Number������
		System.out.println(it instanceof Number);
		// int������
		System.out.println(Integer.MAX_VALUE);
		// int����Сֵ
		System.out.println(Integer.MIN_VALUE);
		
		//2.�ַ���ת��
		//2.1 ����ת�ַ���
		int j = 5;
		// ����1��ʹ��String��ľ�̬����valueOf
		String str = String.valueOf(j);
		System.out.println(str);
		// ����2���Ȱѻ�������װ��Ϊ����Ȼ����ö����toString
		Integer jt = j;
		String str1 = jt.toString();
		System.out.println(str1);
		//2.2 �ַ���ת����
		//����Integer�ľ�̬����parseInt
		String str2 = "999";
		int i3 = Integer.parseInt(str2);
		System.out.println(i3);
		
		//3.Math����
		//java.lang.Math�ṩ��һЩ���õ���ѧ���㷽�������Ҷ����Ծ�̬��������ʽ����
		float f1 = 5.4f;
		float f2 = 5.5f;
		System.out.println(Math.round(f1));
		System.out.println(Math.round(f2));
		
		// �õ�һ��0-1֮������������
		System.out.println(Math.random());
		// �õ�һ��0-10֮������������
		System.out.println(Math.random()*10);
		System.out.println(Math.sqrt(8)); // ƽ��
		System.out.println(Math.pow(2,4)); // �η�(2��4�η�)
		// ��
		System.out.println(Math.PI);
		// ��Ȼ����
		System.out.println(Math.E);
		
		//3.��ʽ�����
		//%s��ʾ�ַ�����%d��ʾ����;%n��ʾ����
		String name = "JonnyTang";
		String hobbys = "football,reading and so on";
		String sentenceFormat = "%s�İ����У�%s\n";
		System.out.printf(sentenceFormat, name, hobbys);
		System.out.format(sentenceFormat, name, hobbys);
		
		//4.�ַ�
		char c1 = 'a';
		char c2 = '1';
		char c3 = '��';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		//char��Ӧ��װ����Character
		char c4 = 'j';
		Character c5 = c4;
		c4 = c5;
		System.out.println(c4);
		System.out.println(c5);
		//Character�����ķ���
		System.out.println(Character.isLetter('j')); //�ж��Ƿ�Ϊ��ĸ
		System.out.println(Character.isDigit('j')); //�ж��Ƿ�Ϊ����
		System.out.println(Character.isWhitespace(' ')); //�Ƿ��ǿհ�
		System.out.println(Character.isUpperCase('j')); //�Ƿ��д
		System.out.println(Character.isLowerCase('j')); //�Ƿ�Сд
		
		System.out.println(Character.toUpperCase('j')); //ת��Ϊ��д
		System.out.println(Character.toLowerCase('J')); //ת��ΪСд
		System.out.println(Character.toString('j')); //ת��Ϊ�ַ���
		
		//5.�����ַ����ĳ�������
		String strTest = " ���ǹ�����������˭�� ";
		System.out.println(strTest.charAt(0)); //�������������ַ�
		char[] cs = strTest.toCharArray();  //��ȡ��Ӧ�ַ�����
		System.out.println(strTest.length() == cs.length);
		System.out.println(strTest.substring(3));  //��ȡ���ַ���
		System.out.println(strTest.substring(2, 5));  //��ȡ���ַ���(����ҿ�)
		String[] strSplit = strTest.split("��"); //�ָ��ַ���
		for (int k = 0; k < strSplit.length; k++) {
			System.out.println(strSplit[k]);
		}
		System.out.println(strTest.trim());  //ȥ����β�ո�
		//��Сд
		String strTest1 = "I'm JonnyTang!";
		System.out.println(strTest1.toUpperCase()); //��д
		System.out.println(strTest1.toLowerCase()); //Сд
		//��λ
		System.out.println(strTest1.indexOf('J'));
		System.out.println(strTest1.contains("Ta"));
		//�滻
		System.out.println(strTest1.replaceAll("n", "m"));
		
		//6.�ַ����Ƚ�
		//�Ƿ�ͬһ������
		String str3 = "dog";
		String str4 = new String(str1);
		System.out.println(str3 == str4); //str3��str4������һ���ģ�������ͬһ������
		String str5 = "dog";
		System.out.println(str3 == str5); //"dog"������������ֻ��һ��
		String str6 = "DOG";
		System.out.println(str3.equals(str6)); //�����Ƿ���ͬ
		
		//7.�ɱ䳤���ַ���
		String str7 = "change here ";
		StringBuffer sb = new StringBuffer(str7);
		sb.append("right now!");  //׷��
		System.out.println(sb);
		sb.delete(6, 11);  //ɾ��6-11֮����ַ�,����ҿ�
		System.out.println(sb);
		sb.insert(7, "world"); //����
		System.out.println(sb);
		sb.reverse();   //��ת
		System.out.println(sb);
		//����������
		System.out.println(sb.length());
		System.out.println(sb.capacity());
	}

}
