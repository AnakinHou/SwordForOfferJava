package problem41;
/*
 * ������41����Ϊs���������֣���Ϊs��������������
 * ����1������һ����������������һ������s.�������в���������ʹ���ǵĺ�Ϊs������ж�����ֵĺ͵���s���������һ�Լ��ɡ�
 * ˼·���̶�һ������Ȼ������������ֵĸ��Ӷ�O(n^2)�ķ����϶����ã�ע�����ǵ��������飬����2��ָ��ֱ�ָ��ͷĩβ������С��������Ȼ���жϺ��Ƿ����s����С��s����ǰ�ߵ�ָ����ƣ�������s����ߵ�ָ��ǰ�ơ�һ��ѭ�����ɸ��Ӷ�O(n)��
 * ����2������һ������s����ӡ�����к�Ϊs�������������У����ٺ�������������
 * ˼·������ǰ�ߵ�˼·�����ǿ����ȳ�ʼ����СֵΪ1�����ֵΪ2������жϣ���С��s�����������ֵʹ���а�������ֵ���������б�Ϊ{1��2��3}��������s����Ҫȥ�������е�Сֵ����������Сֵ��
 */
public class FindNumbersWithSum {
	// ����1
	static void q1(int[] arr,int s){
		if(arr == null)
			return;
		int small = 0;
		int big = arr.length-1;
		while(big > small){
			if(arr[small] + arr[big] == s){
				System.out.println(arr[small]);
				System.out.println(arr[big]);
				break;
			}else if(arr[small] + arr[big] > s){
				big--;
			}else{
				small++;
			}
		}
	}
	// ����2
	static void q2(int s){
		if(s < 3)
			return;
		int small = 1;
		int big = 2;
		int mid = (s + 1) / 2;
		int curSum = small + big;
		while(small < mid){
			if(curSum == s){
				for(int i=small;i<=big;i++)
					System.out.println(i);
				curSum -= small;
				small++;
			}else if(curSum > s){
				curSum -= small;
				small++;
			}else{
				big++;
				curSum += big;
			}
		}
	}
	public static void main(String[] args) {
		int[] test = {1,2,4,7,11,15};
		q1(test,15);
		q2(15);
	}
}
