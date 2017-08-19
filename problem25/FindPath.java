package problem25;

import java.util.Stack;
/*
 * ������25���������к�Ϊĳһֵ��·��
 * ����һ����������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·��Ϊ�Ӹ����һֱ��Ҷ��㡣
 * ˼·���Ĳ���1����Ȼ�����������㣬��ô�϶�������������ѽ����ӵ����·���в��ۼ���ֵ��2��������ʵ��Ľ����Ҷ��㲢��ֵ֮���������������ӡ·����3�������ǰ��㲻��Ҷ��㣬�ͼ����ݹ�������ӽ�㡣
 * 4����ǰ�����ʽ����󣬵ݹ麯���Զ��ص��丸��㣬�����ں����˳�ǰҪɾ��·���ϵĸý�㲢��ȥ��ֵ����֤���ظ����ʱ��·���ǴӸ���㵽����㡣���Կ�������·�������ݽṹ�Ǻ���ȳ���ջ��
 */
public class FindPath {
	private void findPath(BiTree root,int expectedSum){
		if(root == null){
			return ;
		}
		Stack<Integer> path = new Stack<>();
		int currentSum = 0;
		findPath(root,expectedSum,path,currentSum);
	}
	private void findPath(BiTree root,int expectedSum,Stack<Integer> path,int currentSum){
		//��һ�����ѽ�����·�����ۼӺ�
		path.push(root.value);
		currentSum += root.value;
		//�ڶ�������������Ҷ��㲢����ֵ��ȵ���������ӡ·��
		boolean isLeaf = root.left == null && root.right ==null;
		if(currentSum == expectedSum && isLeaf){
			System.out.println("A path is found:" + path);
		}
		//�������������㲻��Ҷ��㣬�ݹ�����ӽ��
		if(root.left != null){
			findPath(root.left,expectedSum,path,currentSum);
		}
		if(root.right != null){
			findPath(root.right,expectedSum,path,currentSum);
		}
		//���Ĳ��������Ҷ��㣬����ֵ����ȣ������˳����丸��㣬��·����ɾȥ������
		path.pop();
		currentSum -= root.value;
	}
	public static void main(String[] args) {
		FindPath test = new FindPath();
		BiTree A1 = new BiTree(1);
		BiTree A2 = new BiTree(2);
		BiTree A3 = new BiTree(3);
		BiTree A4 = new BiTree(4);
		BiTree A5 = new BiTree(1);
		A1.left = A2;
		A1.right = A3;
		A2.left = A4;
		A2.right = A5;
		test.findPath(A1, 4);
	}
}
class BiTree{
	int value;
	BiTree left,right;
	BiTree(int x){
		value = x;
	}
}