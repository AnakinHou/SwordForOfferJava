package problem06;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * ������6���ؽ���������
 * �����������ǰ�����������������,�ؽ������������������ǰ����������������ظ�����������:ǰ��12473568,����47215386,���������������
 * ˼·����νǰ�к��򼴸��ڵ�ķ���˳��ǰ��ĵ�һ�����϶��Ǹ��ڵ㣬�����ڵ�����������м�λ�ã�����Ϊ���������ұ�����������
 * ��������ĸ��ڵ������3��������֪���ڵ����������3���ڵ㣬��ʱ����������˳������������������ôǰ��ĵ�һ�����ĺ���������϶�Ҳ���������������Ǹ���������ǰ��
 * ��ô����������ǰ����������ˣ��Ϳ��Եݹ��ˡ�
 */
class BinaryTreeNode{
	int value;
	BinaryTreeNode leftNode,rightNode;
}
public class Construct {
	static BinaryTreeNode rebuild(int[] preorder,int[] inorder){
		BinaryTreeNode root = rebuild(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
		return root;
	}
	//���������ӱ������Լ�������ʼ�ͽ�����λ��
	static BinaryTreeNode rebuild(int[] preorder,int startPre,int endPre,int[] inorder,int startIn,int endIn){
		if( startPre > endPre || startIn > endIn || preorder.length != inorder.length){
			return null;
		}
		boolean haveRoot = false;
		//ǰ���һ����Ϊ���ڵ�
		BinaryTreeNode root = new BinaryTreeNode();
		for(int i=startIn;i<=endIn;i++){
			//�Ҹ��ڵ�
			if(inorder[i] == preorder[startPre]){
				haveRoot = true;
				root.value = preorder[startPre];
				root.leftNode = rebuild(preorder, startPre+1, startPre+1+(i-startIn), inorder, startIn, i-1);
				root.rightNode = rebuild(preorder, i-startIn+startPre+1, endPre, inorder, i+1, endIn);
				//�����������Ƚϸ��ӣ���һ���ø�������ķ��������(������һ��)��
				//root.leftNode = rebuild(Arrays.copyOfRange(preorder, 1, i+1), Arrays.copyOfRange(inorder, 0, i));
				//root.rightNode = rebuild(Arrays.copyOfRange(preorder, i+1, preorder.length), Arrays.copyOfRange(inorder, i+1,inorder.length));
			}
		}
		if(!haveRoot){
			System.out.println("û���ҵ����ڵ�");
			return null;
		}
		return root;
	}
	//���������
	static void postorder(BinaryTreeNode root){
		if(root == null){
			System.out.println("���ڵ�Ϊ��");
		}
		if(root.leftNode != null){
			postorder(root.leftNode);
		}
		if(root.rightNode != null){
			postorder(root.rightNode);
		}
		System.out.println(root.value);
	}
	public static void main(String[] args) {
		int[] preorder = {1,2,4,7,3,5,6,8};
		int[] inorder = {4,7,2,1,5,3,8,6};
		postorder(rebuild(preorder, inorder));
	}
}