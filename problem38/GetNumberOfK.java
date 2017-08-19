package problem38;
/*
 * ������38�����������������г��ֵĴ���
 * ��������{1,2,3,3,3,3,4,5}��3������3������4�Σ����4��
 * ˼·��˳����Ҹ��Ӷ�ΪO(n)��������O(logn)�ķ����������ö��ֲ��ң��ҵ������ֵ�һ�γ��ֺ����һ�γ��ֵ�λ�ü��ɣ�������롣
 */
public class GetNumberOfK {
	
	// ���ַ��ҵ�һ�����ֵ�k
	static int getFirstK(int[] arr, int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		if(arr[mid] == k){
			if((mid > 0 && arr[mid-1] != k) || mid == 0)
				return mid;
			else
				end = mid - 1;
		}else if(arr[mid] > k)
			end = mid - 1;
		else
			start = mid + 1;
		return getFirstK(arr, k, start, end);
	}
	// ���ַ������һ��k
	static int getLastK(int[] arr, int k, int start, int end){
		if(start > end)
			return -1;
		int mid = (start + end) / 2;
		if(arr[mid] == k){
			if((mid < arr.length-1 && arr[mid+1] != k) || mid == arr.length-1)
				return mid;
			else
				start = mid + 1;
		}else if(arr[mid] < k)
			start = mid + 1;
		else
			end = mid - 1;
		return getLastK(arr, k, start, end);
	}
	
	// �������
	static int getNumberOfK(int[] arr, int k){
		int number = 0;
		if(arr != null && arr.length > 0){
			int first = getFirstK(arr, k, 0, arr.length-1);
			int last = getLastK(arr, k, 0, arr.length-1);
			if(first >= 0 && last >= 0)
				number = last - first + 1;
		}
		return number;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,3,3,3,4,5};
		int k = 3;
		System.out.println(getNumberOfK(arr, k));
	}
}
