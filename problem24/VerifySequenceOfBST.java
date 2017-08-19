package problem24;

import java.util.Arrays;

/*
 * ������24�������������ĺ����������(�ݹ�)
 * ����һ�����飬�ж������ǲ��Ƕ����������ĺ�����������
 * ˼·��ע������������������<��<�Һ��ӣ��������е����һ�����Ǹ���ǰ�߱ȸ�С�������������ȸ��������������Ȼ������������ݹ顣
 * �����Ŀ��������ǰ��Ҳ�����˼·�����ı����ؼ��������Ҹ���㡣
 */
public class VerifySequenceOfBST {
	private boolean verifySequenceOfBST(int[] arr){
		if(arr == null || arr.length<=0){
			return false;
		}
		int root = arr[arr.length-1];//��������һ�����Ǹ�
		int i = 0;//�ָ�����Ϊ��������,����������ʼλ�õ��±�
		for(;i<arr.length-1;i++){
			if(arr[i] > root){//���������С�ڸ��ڵ�
				break;
			}
		}
		int j = i;
		for(;j<arr.length-1;j++){//�����������ڸ��ڵ�
			if(arr[j] < root){
				return false;
			}
		}
		//�ݹ��ж��������ǲ��Ƕ���������
		boolean left = true;
		if(i > 0){
			left = verifySequenceOfBST(Arrays.copyOfRange(arr, 0, i));
		}
		//�ݹ��ж��������ǲ��Ƕ���������
		boolean right = true;
		if(i < arr.length-1){
			right = verifySequenceOfBST(Arrays.copyOfRange(arr, i, arr.length-1));//�ǵ�ȥ�����һ�������
		}
		return left && right;
	}
	public static void main(String[] args) {
		VerifySequenceOfBST test = new VerifySequenceOfBST();
		int[] a = {5,7,6,9,11,10,8};
		System.out.println(test.verifySequenceOfBST(a));
	}
}
