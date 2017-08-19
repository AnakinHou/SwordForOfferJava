package problem22;
import java.util.Stack;
/*
 * ������22��ջ��ѹ�뵯������
 * ���������������У���һ�����б�ʾѹ��˳���жϵڶ��������Ƿ�Ϊ����˳��.������ջ�������־�����ȡ�
 * ˼·����������ջ����ѹ������1��2��3��4��5����������4��5��3��2��1Ϊ������һ����������4������Ҫ�Ȱ�4ѹ��ջ����ʱջ����1234������ջ�����ɣ���һ������5��������ѹ��ֱ��5,������
 * �پٸ��������Ե�������4��3��5��1��2Ϊ��������ջ����1234�ˣ���һ������3������ջ��Ӧ��Ϊ3������ʱջ��Ϊ4�����Բ�ƥ�䡣
 */
public class IsPopOrder {
	static boolean ispoporder(int[] a,int[] b){
		if(a == null || b == null || a.length  != b.length){
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int pushIndex = 0;
		int popIndex = 0;
		boolean tag = false;
		while(popIndex < a.length){
			while(stack.isEmpty() || stack.peek() != b[popIndex]){//ѹ������,ֱ����ǰ��������ֵ��ջ��ֵ��ȡ�
				if(pushIndex == a.length){
					break;
				}
				stack.push(a[pushIndex]);
				pushIndex++;
			}
			if(stack.peek() != b[popIndex]){
				break;
			}
			stack.pop();
			popIndex++;
		}
		if(stack.isEmpty() && popIndex == a.length){
			tag = true;
		}
		return tag;
	}
	public static void main(String[] args){
		int[] a = {1,2,3,4,5};
		int[] b = {4,5,3,2,1};
		System.out.println(ispoporder(a, b));
	}
}
