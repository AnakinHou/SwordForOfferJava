package problem47;
/*
 * ������47�����üӼ��˳����ӷ�
 * ˼·����λ�������������һ�������ǽ�λ��ÿһλ��ӣ�������������Ľ�������ڶ������½�λ��ֻ��1+1�������λ����������������������һλ���������������������ֱ�Ϊ���Ľ������Ľ�����ظ�ǰ������ֱ����������λ��
 * ������⣺��ʹ���±�����������������ֵ
 * ���ڼӼ�����
 * a = a + b;
 * b = a - b;
 * a = a - b;
 * �������
 * a = a ^ b;
 * b = a ^ b;
 * a = a ^ b;
 */
public class Add {
    public static int add(int num1, int num2){
        int sum, carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(add(5, 17));
    }
}
