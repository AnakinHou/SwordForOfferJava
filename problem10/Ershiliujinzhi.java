package problem10;

import java.util.Scanner;

/* 
 * �����Ŀ3������ת�����⣬��Excel2003�У���A��ʾ��һ�У�B��ʾ�ڶ���...Z��ʾ��26�У�AA��ʾ��27�У�AB��ʾ��28��...�������ơ���д��һ����������������ĸ��ʾ���кű��룬������ǵڼ��С�
 * �����Ŀ4�����������������������26���Ʊ�ʾ�أ�
 */
public class Ershiliujinzhi {
	static int test(String str){
		char[] strArr = str.toCharArray();
		int number = 0;//��������
		int exp = 0;//26��ָ��
		for(int i=strArr.length-1;i>=0;i--){
			number += (strArr[i]-'A'+1)*Math.pow(26,exp);//Matn.pow����
			exp++;
		}
		return number;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.next();
			System.out.println(test(str));
			System.out.println(test2(27));
		}
		sc.close();
	}
	//�����4
	static String test2(int number){
		StringBuilder sb = new StringBuilder();
		while(number != 0){
			int temp = number % 26;//26���Ʊ�ʾ�����һλ
			number = number / 26;//26���Ʊ�ʾ�ĵ����ڶ�λ
			if(temp == 0){//���һλ��0�Ļ���ǰ��һλ
				temp = 26;
				number = number - 1;
			}
			sb.append( (char) ('A'+temp-1) );//�����Ƿ��򣬺���ٷ�ת
		}
		return sb.reverse().toString();
	}
}