package problem04;
/*
 * ������4��ʵ��һ�����������ַ����еĿո��滻Ϊ%20��
 * ˼·1������һ��String���и��ƻ����滻�ȽϷ��㡣
 * ˼·2����ͳ�ƿո�������ȷ���������String�ܳ��ȣ�һ��ָ��a��ԭʼ�ַ���ĩβ��һ��ָ��b����������ַ���ĩβ����ǰ�ƶ�a�����ַ����Ƹ�b��ֱ�������ո�
 * ˼·3�������ո�ͺ����ַ������ǲ��õķ��������Ӷ�n*n����������ϲ��ַ�����������ʱ��ǰ��������Ҫ�ƶ��ַ���Σ���ô�Ϳ��ǴӺ���ǰ�Լ����ƶ�������
 * �����Ŀ��������������A1��A2��A1ĩβ���㹻�Ŀռ�����A2�����A2���뵽A1�в��ź���
 * ˼·����β��ͷ�Ƚ�A1��A2���ѽϴ�����ַ���A1�ĺ���λ�á�
 */
import java.util.Scanner;

public class ReplaceBlank {
	static String input(){
		Scanner sc = new Scanner(System.in);
		System.out.println("�����룺");
		String input = sc.nextLine();
		sc.close();
		return input;
	}
	static String replace(String input){
		if (input == null) {
			return null;
		}
		StringBuffer output = new StringBuffer();
		for(int i=0;i<input.length();i++){
			if (input.charAt(i) == ' ') {
				output.append("%20");
				//Ҳ���Բ���StringBuffer��������ȥ������char[] xxx=input.toCharArray();
			}else{
				output.append(input.charAt(i));
			}
		}
		return new String(output);
	}
	public static void main(String[] args) {
		System.out.println(replace(input()));
	}
}
