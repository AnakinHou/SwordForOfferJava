package problem08;
/*
 * ������8����ת�������С����
 * ��һ�������ʼ�ļ���Ԫ�ذᵽ����ĩβ�����ǳ�֮Ϊ�������ת������һ���������������ת�����������СԪ�ء���{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����1��
 * ˼·��ֱ���뷨�Ǵ�ͷ��β�������У����Ӷ�O(n)���������������ʵ�Ѿ�����Ϊ�����ź���������飬ǰ��һ���������Ԫ�ض����ڵ��ں��һ����������СԪ��Ϊ�ֽ硣
 * �����ź�������飬�Ƽ��ö��ֲ��Ҹ��Ӷ�ΪO(logn)��������һ��ָ��ָ��Ԫ�أ�һ��ָ��ָβԪ�أ����м�Ԫ�ش��ڵ�����Ԫ�أ�����λ��ǰһ���������ڣ���СԪ�����м�Ԫ��֮�󡣷�֮ͬ��
 */
public class Min {
	//��򵥵Ķ���
	static Integer printMin(int array[]) {
		int low = 0 ;
		int high = array.length - 1;
		if(array.length == 0) return null;//�п�
		while(low < high){
			int mid = (low + high)/2;
			if(array[mid] > array[high]){
				low = mid + 1;
			}else if(array[mid] == array[high]){
				high = high - 1;
			}else{
				high = mid;
			}
		}
		return array[low];
	}
	public static void main(String[] args) {
		int test[] = {3,4,5,1,2};//{2,2,2,1,2}
		System.out.println(printMin(test));
	}
}
