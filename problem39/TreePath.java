package problem39;
/*
 * ������39������������ȣ��Լ��ж�ƽ���������
 * ˼·������������ȿ����õݹ�ȥ���������ֻ�и��ڵ㣬���Ϊ1��������ڵ�ֻ��һ�����������Ϊ���������+1��������������������Ϊ������������Ƚϴ�ֵ��+1��
 * �����ж�ƽ���������˼·�������ϱ�����ȵķ��������Ͽ����뵽ȥ�������ڵ㣬����������������ȵĺ��������ÿ���������������������������1������ƽ����������������ַ������ظ�������㣬Ч��̫�͡�
 * ���ǿ����ú�������ķ����������н�㣬�����ڱ���һ�����֮ǰ���Ǿ��Ѿ���������������������ֻҪ�ڱ���ÿ�����ʱ��¼������ȣ��Ϳ��Դﵽһ�߱���һ���ж�ÿ������ַ�ƽ�⣬������롣
 */
class BiTree{
	int data;
	BiTree left;
	BiTree right;
}
public class TreePath {
	//�ݹ����������
	static int treePath(BiTree root){
		if(root == null)
			return 0;
		int left = treePath(root.left);
		int right = treePath(root.right);
		return left > right ? (left+1) : (right+1);
	}
	// ��Ϊjava�������Ͳ�����ֵ���ݣ��޷���¼ÿ����������ȣ�������һ��������������
	static class Depth{
		int n;
	}
	//�ж�ƽ�������
	static boolean isBalanced(BiTree root){
		Depth depth = new Depth();
		return isBalanced(root, depth);
	}
	static boolean isBalanced(BiTree root, Depth depth){
		if(root == null){
			depth.n = 0;
			return true;
		}
		Depth left = new Depth();
		Depth right = new Depth();
		if(isBalanced(root.left, left) && isBalanced(root.right, right)){
			int diff = left.n - right.n;
			if(diff <= 1 && diff >= -1){
				depth.n = 1 + (left.n > right.n ? left.n : right.n);
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		BiTree node1 = new BiTree();
		BiTree node2 = new BiTree();
		BiTree node3 = new BiTree();
		BiTree node4 = new BiTree();
		BiTree node5 = new BiTree();
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node4.left = node5;
		System.out.println(treePath(node1));
		System.out.println(isBalanced(node1));
	}
}
