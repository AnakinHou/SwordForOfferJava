package problem33;
/*
 * ������33���������ų���С����
 * ����һ�����������飬�����������е���ƴ���������һ�����������С�ġ���������{3,32,321}�����321323��
 * ˼·1��ȫ���У�����������28��n��������n�������У����ӶȱȽϸߡ�
 * ˼·2����дһ�ֱȽϴ�С�ķ�����������롣
 */
import java.util.Arrays;
import java.util.Comparator;

public class PrintMinNumber {
	public static String printMinNumber(int[] numbers) {
		if(numbers == null || numbers.length == 0) return "";
		
		int len = numbers.length;
		String[] str = new String[len];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++){
			str[i] = String.valueOf(numbers[i]);
		}
		// ��д��������򷽷�����󷵻�ʱ�õ��ַ����ȽϷ���������111��1101�Ƚϣ���111��
		Arrays.sort(str,new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				String c1 = s1 + s2;
				String c2 = s2 + s1;
				return c1.compareTo(c2);
			}
		});
		for(int i = 0; i < len; i++){
			sb.append(str[i]);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		int[] a = {3,32,321};
		String b = printMinNumber(a);
		System.out.println(b);
	}
}
