package problem37;
/*
 * ������37����������ĵ�һ���������
 * ������������������������ڵ㡣ע���ˣ���������������й����ڵ㣬��״�϶���Y�͵ģ���Ϊÿ����㶼ֻ��һ��next��㣬��������ڵ�֮�󲻻��з�֧�ˡ�
 * ˼·�����������ȷֱ�Ϊm��n�����ù̶�һ������ĵ�һ����㣬������һ������ķ����ĸ��Ӷ�ΪO(m*n)���е���ˣ����Ի���˼·����Ȼ�����ڵ�֮��Ľ�㶼�ǹ��еģ���������ĳ��Ȳ��ֻ�ڹ����ڵ�֮ǰ�����Կ����ȵó���������ĳ���֮��d���ϳ�����������d����Ȼ����ͬʱ������������ֱ�������ڵ㼴�ɡ�
 */
class ListNode{
	int data;
	ListNode next;
	public ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}
public class FindFirstCommonNode {

	// ����
	static ListNode findFirstCommonNode(ListNode list1, ListNode list2){
		int len1 = getLen(list1);
		int len2 = getLen(list2);
		int diff = 0;
		ListNode longList = null;
		ListNode shortList = null;
		if(len1 != 0 && len2 != 0){
			if(len1 > len2){
				diff = len1 - len2;
				longList = list1;
				shortList = list2;
			}else{
				diff = len2 - len1;
				longList = list2;
				shortList = list1;
			}
			for(int i = diff; i > 0;i--){
				longList = longList.next;
			}
			while(longList != null && shortList != null && longList != shortList){
				longList = longList.next;
				shortList = shortList.next;
			}
		}
		return longList;
	}
	
	// ��������
	static int getLen(ListNode list){
		int len = 0;
		while(list != null){
			len++;
			list = list.next;
		}
		return len;
	}
	
	// main
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode b1 = new ListNode(1);
		ListNode b2 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		b1.next = b2;
		b2.next = a3;
		System.out.println(findFirstCommonNode(a1, b1).data);
	}
}
