package problem26;
/*
 * ������26����������ĸ���
 * ����һ��������������������nextָ�룬����ָ������һ������siblingָ����ָ�롣
 * ˼·1��һ��Ч�ʺܵ͵ķ��������������ȸ���һ��next����Ȼ������siblingָ�롣�����ڲ�֪����ָ���λ�ã�����Ҫ����һ��������ԭ�����У���ͷ���˼��������������У�Ҳ�߼����������ȷ��λ���ˣ�������ÿ���������sibling��Ҫ����O(n)�����ܸ��Ӷ�O(n^2)��
 * ˼·2���ÿռ任ʱ�䣺���ϱ�һ�������������������ڵ�һ����ʱ��Ҫ��¼sibling�������Ϣ��һ����ϣ���У������ڶ���������O(1)ʱ������ɵ����ڵ��sibling�����á���O(n)�Ŀռ临�ӶȻ�����O(n)��ʱ�临�Ӷȡ�
 * ˼·3�����ø����ռ�ʵ��O(n)��Ч�ʣ�������1���������n�ĸ���n'��nָ��n'��n'ָ����һ��ԭʼ��㡣2������sibling��ԭʼ���ָ��˭�����ƵĽ���ָ���Ӧ�ĸ��ơ�3��������������ֳ�����������ɸ��ơ�
 */
public class ComplexList {
	//����
	ComplexListNode clone(ComplexListNode head){
		cloneNodes(head);
		connectSiblingNodes(head);
		return reconnectNodes(head);
	}
	//��һ�������ƽ��
	void cloneNodes(ComplexListNode head){
		ComplexListNode p = head;
		while(p != null){
			ComplexListNode cloned = new ComplexListNode(p.value);
			cloned.next = p.next;
			p.next = cloned;
			p = cloned.next;
		}	
	}
	//�ڶ���������sibling
	void connectSiblingNodes(ComplexListNode head){
		ComplexListNode p = head;
		while(p != null){
			if(p.sibling != null){
				p.next.sibling = p.sibling.next;
			}
			p = p.next.next;
		}
	}
	//�����������
	ComplexListNode reconnectNodes(ComplexListNode head){
		ComplexListNode p = head;
		ComplexListNode clonedHead = null;
		ComplexListNode tempHead = null;
		if(p != null){
			clonedHead = p.next;
			tempHead = clonedHead;
			p.next = clonedHead.next;
			p = p.next;
		}
		while(p != null){
			tempHead.next = p.next;
			tempHead = tempHead.next;
			p.next = tempHead.next;
			p = p.next;
		}
		return clonedHead;
	}
	//��ӡ
	void print(ComplexListNode head){
		if(head == null ) return;
		while(head != null){
			System.out.println(head.value);
			if(head.sibling != null){
				System.out.println(head.sibling);
			}
			head = head.next;
		}
	}
	public static void main(String[] args) {
		ComplexList test = new ComplexList();
		ComplexListNode root=new ComplexListNode(0);
		ComplexListNode node1=new ComplexListNode(1);
		ComplexListNode node2=new ComplexListNode(2);
		ComplexListNode node3=new ComplexListNode(3);
		ComplexListNode node4=new ComplexListNode(4);
		root.next = node1;
		root.sibling = node2;
		node1.next = node2;
		node1.sibling = node4;
		node2.next = node3;
		node3.next = node4;
		test.print(root);
		test.print(test.clone(root));
	}
}
class ComplexListNode{
	int value;
	ComplexListNode next,sibling;
	ComplexListNode(int x){
		value = x;
	}
} 