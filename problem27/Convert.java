package problem27;
/*
 * ������27��������������˫������
 * ������������ת����һ�������˫������Ҫ���ܴ����µĽ�㣬ֻ�ܸı����н���ָ��
 * ˼·�����������������������ź���ģ����������������˫�����������һ���������������Ľ��������Ҳһ������������С�Ľ��������Ȼ��������������ĸ���㣬�ݹ鴦��
 */
public class Convert {
	private BiTree convert(BiTree root){//���ﷵ�ض�������ʾ��˫������
		BiTree lastNode = null;//ָ��˫������β��(ֵ���Ľ��)
		BiTree headNode = convertNode(root,lastNode);//��ߺ������ص���˫������β��㣬������Ҫͷ���
		while(headNode != null && headNode.left != null){
			headNode = headNode.left;
		}
		return headNode;
	}
	private BiTree convertNode(BiTree root,BiTree lastNode){
		if(root == null){
			return null;
		}
		BiTree current = root;
		//���������������ҵ�˳����,��
		if(current.left != null){
			lastNode = convertNode(current.left, lastNode);
		}
		//��,��ʱlastNodeӦ�������������ֵ����������󣬸�������µ�lastNode
		current.left = lastNode;
		if(lastNode != null){
			lastNode.right = current;
		}
		lastNode = current;
		//��
		if(current.right != null){
			lastNode = convertNode(current.right, lastNode);
		}
		return lastNode;
	}
	public static void main(String[] args) {
		Convert test = new Convert();
		BiTree A1 = new BiTree(4);
		BiTree A2 = new BiTree(2);
		BiTree A3 = new BiTree(5);
		BiTree A4 = new BiTree(1);
		BiTree A5 = new BiTree(3);
		A1.left = A2;
		A1.right = A3;
		A2.left = A4;
		A2.right = A5;
		BiTree a = test.convert(A1);
		while(a != null){
			System.out.println(a.value);
			a = a.right;
		}
	}
}
class BiTree{
	int value;
	BiTree left,right;
	BiTree(int x){
		value = x;
	}
}