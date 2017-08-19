package problem42;
/*
 * ������42����ת����˳������ת�ַ���
 * ��Ŀ1������һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵��������ַ���˳�򲻱䡣
 * ˼·��дһ����ת�ַ����ĺ������ȷ�ת�������ӣ��ٷ�תÿ�����ʡ�
 * ��Ŀ2��ʵ���ַ�����������������abcdefg������2�����cdefgab��
 * ˼·��ͬ���ȷ�ת�������ӣ��ٷ�ת�����ִ���
 */
public class ReverseSentence {
	// ��ת�ַ����ĺ���
	static String reverse(String str){
		if(str == null)
			return null;
		char[] arr = str.toCharArray();
		for(int i=0;i<(arr.length+1)/2;i++){
			char tmp = arr[i];
			arr[i] = arr[arr.length-i-1];
			arr[arr.length-i-1] = tmp;
		}
		return String.valueOf(arr);
	}
	// ��Ŀ1
	static void q1(String str){
		if(str == null)
			return;
		String tmp = reverse(str);
		String[] items = tmp.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String item : items){
			sb.append(reverse(item) + " ");
		}
		System.out.println(sb.toString());;
	}
	// ��Ŀ2
	static void q2(String str,int n){
		if(str == null || n > str.length() || n < 0)
			return ;
		String tmp = reverse(str);
		String[] items = {tmp.substring(0, tmp.length()-n), tmp.substring(tmp.length()-n, tmp.length())};
		StringBuilder sb = new StringBuilder();
		for(String item : items){
			sb.append(reverse(item));
		}
		System.out.println(sb.toString());
	}
	public static void main(String[] args) {
		q1("I am your father!");
		q2("woyouyijummp",5);
	}
}
