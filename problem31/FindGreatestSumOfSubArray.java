package problem31;
/*
 * ������31�����������������
 * ����һ�����������飬�����и��������е�һ������������������飬������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
 * �������������Ϊ{1,-2,3,10,-4,7,2,-5}��������������Ϊ{3,10,-4,7,2}��������Ϊ��������ĺ�18��
 * ˼·����ͷ��β����ۼ������е�������Ϊ��ǰ�ͣ���ʼ��Ϊ0�������ǰ��С�ڵ���0����ô����һ��Ҫ�ۼӵ�����Ӻ�϶��������С�����Ե�ǰ�ͼ�Ϊ������������ģ�֮ǰ�������������ǰ�ʹ���0�����µ�ǰ��Ϊ��������һ��������������ǰ�ͱ����ͻ��󣬾͸������͡�
 */
public class FindGreatestSumOfSubArray {
	public static Integer findGreatestSumOfSubArray(int[] arr){
		if(arr == null || arr.length <= 0){
			System.out.println("Invalid Input");
			return 0;
		}
		int curSum = 0; //��ǰ��
		int greatestSum = Integer.MIN_VALUE; //���ͣ���ʼֵ��Ϊint����Сֵ������������ȫ�Ǹ����������
		for(int i=0;i<arr.length;i++){
			if(curSum <= 0){
				curSum = arr[i];
			}else{
				curSum += arr[i];
			}
			if(curSum > greatestSum){
				greatestSum = curSum;
			}
		}
		return greatestSum;	
	}
	public static void main(String[] args) {
		int[] arr = {1,-2,3,10,-4,7,2,-5}; 
		int sum = findGreatestSumOfSubArray(arr);
		System.out.println(sum);
	}
}
