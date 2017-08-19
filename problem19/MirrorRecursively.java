package problem19;

import java.util.Stack;

/*
 * ������19���������ľ���(�ݹ�ͷǵݹ�)
 */
public class MirrorRecursively {
	//�ݹ飬�Ƚ������������ӽ�㣬Ȼ��ݹ���������ӽ�㡣
	static void mirrorRecursively(BiTree tree){
		if(tree != null){
			BiTree temp = tree.left;
			tree.left = tree.Right;
			tree.Right = temp;
			if(tree.left != null) mirrorRecursively(tree.left);
			if(tree.Right != null) mirrorRecursively(tree.Right);
		}
	}
	//�ǵݹ飬��ջ�������Ƚ��������ӽ�㣬Ȼ��Ѹ����ѹ��ջ��ȡ���ӽ��Ϊ�µĸ���㣬ֱ���������ӽ��Ϊ�գ�֮�������ջ��ȡ���ӽ��Ϊ�µĸ���㣬ѭ����
	static BiTree zhan(BiTree tree){
		BiTree p = tree;
		Stack<BiTree> stack = new Stack<>();
		while(p != null || !stack.isEmpty()){//���Ϊ�գ���ջΪ��ʱ����
			while(p != null){
				BiTree temp = p.left;
				p.left = p.Right;
				p.Right = temp;
				stack.push(p);
				p=p.left;
			}
			p = stack.pop();
			p = p.Right;
		}
		return tree;
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