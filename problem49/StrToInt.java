package problem49;
/*
 * ������49���ַ���ת����
 * �����������ָint��Ҫ���ǵ��������£�1������null��մ���2�������ţ�3���Ƿ��ַ���4��intԽ�磨���Է������Ͷ���Ϊlong����
 */
public class StrToInt {
	public static long str2int(String str) throws Exception{
		if(str == null || str.length() == 0)
			throw new Exception("null or empty");
		long number = 0; // Ҫ���ص�intֵ
		boolean minus = false; // �Ƿ�Ϊ��
		int index = 0; // str�±�
		// ��λ�Ƿ���������
		if(str.charAt(index) == '+')
			index++;
		else if(str.charAt(index) == '-'){
			index++;
			minus = true;
		}
		// �����λ�������ţ��ж��ַ������Ƿ����1������1������λ���������ŵĻ��ͽ���ִ��
		if(index < str.length()){
			int flag = minus ? -1 : 1;
			while(index < str.length()){
				// �жϷǷ�����
				if(str.charAt(index) >= '0' && str.charAt(index) <= '9'){
					int digit = str.charAt(index) - '0';
					number = number * 10 + flag * digit;
					index++;
					// �ж�intԽ��
					if((!minus && number > Integer.MAX_VALUE) || (minus && number < Integer.MIN_VALUE))
						throw new Exception("out of the int maximum or minimum");
				}else
					throw new Exception("wrong input format");
			}
		}else
			throw new Exception("only '+' or '-', no more number");
		return number;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(str2int("-123"));
	}
}
