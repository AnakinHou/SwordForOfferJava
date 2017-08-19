package problem18;
/*
 * ������18�������ӽṹ(�ݹ�)
 * �ж϶�����B�ǲ��Ƕ�����A������.
 * ˼·��������1���ݹ����hasSubtree�ȱ���A����û�н���ֵ��B�ĸ������ͬ������У�����doesTree1HaveTree2���ڶ����жϡ�2���ж�AB�ṹ�Ƿ���ͬ�����ݹ��ж����ҽ�㡣
 */
public class DoesTree1HaveTree2 {
	private boolean doseTree1HaveTree2(BiTree A,BiTree B){
		if(B == null) return true;//ע��if˳��
		if(A == null) return false;
		if(A.value != B.value) return false;
		return doseTree1HaveTree2(A.left, B.left) && doseTree1HaveTree2(A.Right, B.Right);
	}
	private boolean hasSubTree(BiTree A,BiTree B){
		boolean result = false;
		if(A != null && B != null){
			if(A.value == B.value){
				result = doseTree1HaveTree2(A,B);
			}
			if(!result){
				result = hasSubTree(A.left, B);
			}
			if(!result){
				result = hasSubTree(A.Right, B);
			}
		}
		return result;
	}
	public static void main(String[] args){
		DoesTree1HaveTree2 test = new DoesTree1HaveTree2();
		BiTree A1 = new BiTree(0);
		BiTree A2 = new BiTree(1);
		BiTree A3 = new BiTree(2);
		BiTree A4 = new BiTree(3);
		BiTree A5 = new BiTree(4);
		A1.left = A2;
		A1.Right = A3;
		A2.left = A4;
		A2.Right = A5;
		BiTree B1 = new BiTree(1);
		BiTree B2 = new BiTree(3);
		BiTree B3 = new BiTree(4);
		B1.left = B2;
		B1.Right = B3;
		System.out.println(test.hasSubTree(A1, B1));
	}
}
class BiTree{
	int value;
	BiTree left;
	BiTree Right;
	BiTree(int x){
		value = x;
	}
}