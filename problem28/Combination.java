package problem28;
import java.util.Stack;
/*
 * ������չ������������ַ����������У��������ַ�����������أ�
 * ��������abc�������ǵ�����У�a,b,c,ab,ac,bc,abc��ע��ab��ba�ǲ�ͬ�����У�������һ����ϡ�����ټ���һ���޶�����m=2�������ab,ac,bc��
 * ˼·�����԰�n���ַ��ֳ������֣���һ���ַ��������ַ��������������ڳ���Ϊn���ַ�������m���ַ�����ϣ������ȴ�ͷɨ���ַ����ĵ�һ���ַ���
 * ��Ե�һ���ַ�������������ѡ��һ�ǰ�����ַ��ŵ������ȥ��������������Ҫ��ʣ�µ�n-1���ַ���ѡȡm-1���ַ������ǲ�������ַ��ŵ������ȥ��������������Ҫ��ʣ�µ�n-1���ַ���ѡ��m���ַ�����ջ�洢ѡ�����ַ����ݹ�ʵ�֡�
 * ע�⣺�˷���������û���ظ��ַ�����������������������������aba�ľͲ����ˣ���Ϊ��������ظ��ġ�����취������abaǰ��ȥ�ر�Ϊab��Ȼ���ab��Ϊ���롣
 */
public class Combination {
	public static int count = 0;//ȫ�ֱ�����ͳ���ж�������ϣ������Ǵ�ӡһ�ξͼ�һ��
	
	public static void main(String[] args) {
		char[] a = "aaaaaaaabb".toCharArray();
		a = removeDuplication(a);//ȥ���ظ��ַ�
		combiantion(a);
		System.out.println(count);
	}
	public static void combiantion(char[] str){
		if(str == null) return ;//�п�
		Stack<Character> stack = new Stack<Character>();//��ջ�洢�ַ�
		for(int m = 1; m <= str.length; m++){//�����m��ʾ��n��ѡȡm���ַ���m��Ū��ѭ����ʾ��ȫ����϶���ʾ����������޶�m��ֵ��ֻ��ʾ����Ϊm����ϡ�
			combine(str, 0, m, stack);
		}
	}
	//���ַ������е�begin���ַ���ʼ��ѡm���ַ�����ջ��
	public static void combine(char[] str, int begin, int m, Stack<Character> stack){
        if(m == 0){//ѡȡ��ɴ�ӡһ�Σ�����
        	System.out.println(stack.toString());
        	count++;
        	return ;
        }
        if(begin == str.length){//�ַ�����������������
        	return;
        }
        //��Ե�begin���ַ�������ѡ��ѡ��1��������ַ��Ž�����У�������������Ҫ��ʣ�µ�n-1���ַ���ѡȡm-1���ַ�
        stack.push(str[begin]);
        combine(str, begin + 1, m - 1, stack);
        //ѡ��2����������ַ��ŵ������ȥ��������������Ҫ��ʣ�µ�n-1���ַ���ѡ��m���ַ���
        stack.pop();
        combine(str, begin + 1, m, stack);
	}
	static char[] removeDuplication(char[] str){
		if(str == null || str.length == 0){
			return null;
		}
		StringBuilder temp = new StringBuilder();//��string��+��Ч�ʸ�
		temp.append(str[0]);
		for(int i = 1;i<str.length;i++){
			boolean tag = true;//û�ظ�Ϊture
			for(int j = 0;j<temp.length();j++){
				if(str[i] == temp.charAt(j)){
					tag = false;//�ظ�����false
					break;
				}
			}
			if(tag){
				temp = temp.append(str[i]);
			}
		}
		return temp.toString().toCharArray();
	}
}
