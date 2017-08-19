package problem21;

import java.util.Stack;

/*
 * ������21������min������ջ
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�Min�������ڸ�ջ��,min,push,pop��ʱ�临�Ӷȶ���O(1)��
 * ˼·��������ջ��һ������������һ������Сֵ����ջʱ�����ֵ����Сջջ����ֵС�����룬��������һ����Сջջ��ֵ��ÿ��ȡminʱ��ȡ��Сջջ����
 */
public class StackWithMin<T>{
	Stack<T> stack = new Stack<>();
	Stack<T> minStack = new Stack<>();
	public void push(T t){
		stack.push(t);
		if(minStack.isEmpty() || (Integer)t < (Integer)minStack.peek()){
			minStack.push(t);
		}else{
			minStack.push(minStack.peek());
		}
	}
	public void pop(){
		if(!stack.isEmpty() && !minStack.isEmpty()){
			stack.pop();
			minStack.pop();	
		}
	}
	public void min(){
		if(!minStack.isEmpty()){
			System.out.println(minStack.peek());
		}
	}
	public static void main(String[] args){
		StackWithMin<Integer> test = new StackWithMin<Integer>();
		test.push(2);
		test.push(2);
		test.push(3);
		test.min();//2
		test.push(1);
		test.min();//1
		test.pop();
		test.min();//2
	}
}
