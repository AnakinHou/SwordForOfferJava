package problem07;
import java.util.Queue;
import java.util.LinkedList;

//����⣬��������ʵ��ջ��
public class CStack {
	//��LinkedList��ʵ����Queue�ӿ�
	private static Queue<Integer> queue1 = new LinkedList<>();
	private static Queue<Integer> queue2 = new LinkedList<>();
	
	private void appendTail(int elem){
		//Queueʹ��ʱҪ��������Collection��add()��remove()����������Ҫʹ��offer()������Ԫ�أ�ʹ��poll()����ȡ���Ƴ�Ԫ�ء�
		//���ǵ��ŵ���ͨ������ֵ�����жϳɹ����add()��remove()������ʧ�ܵ�ʱ����׳��쳣�� 
		//���Ҫʹ��ǰ�˶����Ƴ���Ԫ�أ�ʹ��element()����peek()������
		//��������ǿյĶ��������ֵ����Ϊ�յĻ������1��ӡ�
		if(!queue2.isEmpty()){
			queue2.offer(elem);
		}else{
			queue1.offer(elem);
		}
		System.out.println("queue1:" + queue1.toString());
		System.out.println("queue2:" + queue2.toString());
	}
	private void deleteHead(){
		//һ����ʾ�ն��У�һ����ʾ�ǿն���
		Queue<Integer> emptyQueue = queue1;
		Queue<Integer> notEmptyQueue = queue2;
		if(!emptyQueue.isEmpty()){
			emptyQueue = queue2;
			notEmptyQueue = queue1;
		}
		//���˷ǿն��е����һ��Ԫ�أ���Ķ���˳���Ƶ��ն���
		while(notEmptyQueue.size()!=1){
			emptyQueue.offer(notEmptyQueue.poll());
		}
		//ɾ���ղ����µ����һ��Ԫ��
		notEmptyQueue.poll();
		
		System.out.println("queue1:" + queue1.toString());
		System.out.println("queue2:" + queue2.toString());
	}

	public static void main(String[] args) {
		CStack test = new CStack();
		test.appendTail(1);
		test.appendTail(2);
		test.appendTail(3);
		test.deleteHead();
		test.appendTail(4);
		test.deleteHead();
	}
}
