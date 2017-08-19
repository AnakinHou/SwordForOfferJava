package problem17;
/*
 * ������17���ϲ��������������(�ݹ�)
 * �������������������ϲ�����������ʹ��������Ȼ�ǵ����ġ�
 * ˼·���ݹ顣ÿ�αȽ���������ĵ�һ����㣬���С�ģ�Ȼ������next���ڵݹ鷵��ֵ��
 */
public class Merge {
	private ListNode merge(ListNode L1,ListNode L2){
		if(L1 == null){
			return L2;
		}else if(L2 == null){
			return L1;
		}
		ListNode mergeHead = null;
		if(L1.value < L2.value){
			mergeHead = L1;
			mergeHead.next = merge(L1.next, L2);
		}else{
			mergeHead = L2;
			mergeHead.next = merge(L1, L2.next);
		}
		return mergeHead;
	}
	//β�巨��������
	private ListNode create(int[] arr){
		if(arr.length == 0){
			System.out.println("��������Ϊ��");
			return null;
		}
		ListNode headNode = new ListNode(arr[0]);
		ListNode p = headNode;
		for(int i= 1;i<arr.length;i++){
			ListNode node = new ListNode(arr[i]);
			p.next = node;
			p = p.next;
		}
		return headNode;
	}
	//��ӡ���
	private void print(ListNode headNode){
		if(headNode == null){
			System.out.println("��ӡʱ����Ϊ��");
			return;
		}
		while(headNode != null){
			System.out.println(headNode.value);
			headNode = headNode.next;
		}
	}
	public static void main(String[] args) {
		int[] a = {1,3,5,7};
		int[] b = {2,4,6,8};
		Merge test = new Merge();
		ListNode A = test.create(a);
		ListNode B = test.create(b);
		System.out.println("A: ");
		test.print(A);
		System.out.println("B: ");
		test.print(B);
		System.out.println("Merge: ");
		test.print(test.merge(A, B));
	}
}
class ListNode{
	int value;
	ListNode next;
	public ListNode(int x) {
		value = x;
	}
}
