package problem07;
import java.util.Stack;
/*
 * ������7��������ջʵ�ֶ���
 * �����������appendTail��deletedHead���ֱ����ڶ���β������ڵ���ڶ���ͷ��ɾ���ڵ�Ĺ��ܡ�
 * ˼·�����Ԫ�ؼ�ѹ��һ��ջs1��ɾ��Ԫ�صĻ�����s1�е�Ԫ�ذ�˳���ȵ�����ѹ��ջs2�У����ǵ���ջs2��Ԫ�ؾ���ʵ���Ƚ��ȳ��ˡ�
 * ����⣺����������ʵ��ջ��
 * ˼·�����Ԫ�ؼ���һ������q1���Ԫ�أ�ɾ��Ԫ�صĻ�����q1��Ԫ�ذ�˳�����Ȼ����ӵ�q2�����q1ʣ��һ��Ԫ�أ�����Ҫ��ջ��Ԫ�ء������Ԫ�صĻ�����ǿյĶ�����ӡ�
 */
public class CQueue {
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	public void appendTail(int elem){
		//���Ԫ�ؾ�ֱ����stack1���
		stack1.push(elem);
		System.out.println("stack1:" + stack1.toString());
	}
	public void deleteHead(){
		//ɾ�������������1��stack2���գ�ֱ�Ӵ�����ͷ������2��stack2�գ�stack1���գ���1���ȵ���ѹ��2���ٴ�2������3�������ա�
		if(!stack2.isEmpty()){
			stack2.pop();
		}else if(!stack1.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			stack2.pop();
		}else{
			System.out.println("����ջ������");
		}
		System.out.println("stack1:" + stack1.toString());
		System.out.println("stack2:" + stack2.toString());
	}
	public static void main(String[] args) {
		CQueue test = new CQueue();
		test.appendTail(1);
		test.appendTail(2);
		test.appendTail(3);
		test.deleteHead();
		test.deleteHead();
		test.appendTail(4);
		test.deleteHead();
	}
}
