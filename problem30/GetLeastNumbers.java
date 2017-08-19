package problem30;

import java.util.Arrays;

/*
 * ������30����С��K����(�漰�������)
 * ����n���������ҳ�������С��k��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4����򵥵ķ���������������������Ӷ�ΪO(nlogn)�������и���ķ�����
 * ˼·1������������29��Ҳ�ÿ��ŵ�˼�롣����һ�ֺ�������ѡ��Ŀ��ŵ�key���ڵ��±��ǲ���k-1�����ˣ���һ��������ģ������Ӷ�ΪO(n)������Ҫ�޸����顣
 * ˼·2������������޸����飬����һ��O(nlogK)�ķ��������ʺϴ��������ݣ������ô���ѱ���K����С������
 * ���ڶѣ�����һ����ȫ��������������ղ����������洢Ϊ���飬�±�Ϊi�Ҹ��ڵ�i=0��������Key[i]>=Key[2i+1]&&Key[i]>=key[2i+2]�ĳ�Ϊ����ѣ������������ӽ�㣬�Ѷ�Ϊ���ֵ��
 * ���ڶ����򣺵�һ�����ѣ������������п����ǲ�����������Ȼ��˳��д����ȫ����������ʽ���ڶ��������ѣ��������һ����Ҷ��㿪ʼ���������������±�Ϊ���һ�������±�-1֮�����2����֤����������ֵ��Ȼ���±��һ�����������������֮��ĺ��ӽ���п��ܲ�����ѵ����ʣ���������ֱ���±�Ϊ0�������еݹ�ͷǵݹ����ַ�����
 * ��������Ǹ���ǰ�߽��õĶ���ȡ�����������һ����㽻����Ȼ���ǰ��len-1�������жѵ�������ȡ�������͵����ڶ�����㽻������ǰ��len-2�����ѵ������Դ�����ֱ�����н�㶼ȡ�������Ѹ��Ӷ�ΪO(n)����һ�Σ������Ѹ��Ӷ�O(logn)����n-1�Σ��ܸ��Ӷ�ΪO(nlogn)���ǲ��ȶ�������
 * ����˼·�ıȽϣ���һ�ָ��Ӷ�O(n)���ȵڶ��ֿ죬����ȱ�����޸������顣�ڶ����ʺϴ�������ݣ�����һ�ζ�һЩ���ݺ������е�k�����Ƚϣ�����һ����ȫ���������ݡ�
 */
public class GetLeastNumbers {
	public static void main(String[] args) {
		GetLeastNumbers test = new GetLeastNumbers();
		test.getLeastNumbers1(new int[]{4,5,1,6,2,7,3,8}, 4);
		test.getLeastNumbers2(new int[]{4,5,1,6,2,7,3,8}, 4);
	}
	//˼·1�����ڿ��ŵ�
	void getLeastNumbers1(int[] array,int k){
		if(array == null || k <= 0 || k > array.length){
			return ;
		}
		int left = 0;
		int right = array.length - 1;
		int keyIndex = partirion(array, left, right);
		while(keyIndex != k-1){
			if(keyIndex > k-1){
				right = keyIndex-1;
				keyIndex = partirion(array, left, right);
			}else{
				left = keyIndex+1;
				keyIndex = partirion(array, left, right);
			}
		}
		for(int i = 0;i<=keyIndex;i++){
			System.out.println(array[i]);
		}
	}
	//һ�ֿ���
	Integer partirion(int[] array,int left,int right){
		if(array == null){
			return null;
		}
		int i = left;
		int j = right;
		int key = array[left];
		while(i < j){
			while(i < j && array[j] >= key){
				j--;
			}
			array[i] = array[j];
			while(i < j && array[i] <= key){
				i++;
			}
			array[j] = array[i];
		}
		array[i] = key;
		return i;
	}
	//˼·2������һ��������k�����ֵĴ����
		void getLeastNumbers2(int[] array,int k){
			if(array==null || k<=0 || k>array.length){
				return ;
			}
			//������������ǰk������������ѣ���k+1������ʼ����ڵ�Ƚϣ����ڸ��ڵ�����ȥ����֮ȡ�����ڵ㲢���Ŵ����
			int[] kArray = Arrays.copyOfRange(array, 0, k);
			buildMaxHeapify(kArray);//���������
			for(int i=k;i<array.length;i++){
				if(array[i] < kArray[0]){//kArray[0]�ǶѶ�
					kArray[0] = array[i];
					maxHeapify(kArray, k, 0);//�滻�Ѷ���ִ�ж������Ե����ѣ���֤�Ѷ������
				}			
			}
			for(int i:kArray){
				System.out.println(i);
			}
		}
		//����
		void buildMaxHeapify(int[] array){
			for(int i = (array.length-2) >> 1; i >= 0; i--){//����i�����һ����Ҷ���������±�
				maxHeapify(array, array.length, i);//������
			}
		}
		//�����ѣ��ݹ鷨������heapSizeΪҪ�����ĶѵĴ�С������parentΪ��ǰ�Ѷ��������±�
		void maxHeapify(int[] array,int heapSize,int parent)
		{
			int left = 2*parent+1;//�����±�
			int right = left+1;//�Һ����±�
			int largest = parent;//���ֵ�±�
			if(left < heapSize && array[left] > array[parent]){
				largest=left;
			}
			if(right < heapSize && array[right] > array[largest]){
				largest=right;
			}
			//����֮���ӽ����ܾͲ�����ѵ������ˣ�Ҫ��������
			if(largest != parent){
				int temp = array[parent];
				array[parent] = array[largest];
				array[largest] = temp;
				maxHeapify(array, heapSize, largest);
			}
		}
		//�����ѣ�ѭ����������heapSizeΪҪ�����ĶѵĴ�С������parentΪ��ǰ�Ѷ��������±�
//		void maxHeapify(int[] array, int heapSize, int parent) {
//		    int temp = array[parent]; // temp���浱ǰ���ڵ�
//		    int child = 2 * parent + 1; // �Ȼ������
//		    while (child < heapSize) {
//		        // ������Һ��ӽ�㣬�����Һ��ӽ���ֵ�������ӽ�㣬��ѡȡ�Һ��ӽ��
//		        if (child + 1 < heapSize && array[child] < array[child + 1]) {
//		            child++;
//		        }
//		        // ���������ֵ�Ѿ����ں��ӽ���ֵ����ֱ�ӽ���
//		        if (temp >= array[child]){
//		        	break;
//		        }
//		        // �Ѻ��ӽ���ֵ���������
//		        array[parent] = array[child];
//		        // ѡȡ���ӽ������ӽ��,��������ɸѡ
//		        parent = child;
//		        child = 2 * child + 1;
//		    }
//		    // ��ԭ�ȸ�����ֵ�������ڵĽ��
//		    array[parent] = temp;
//		}
		//������ִ��֮ǰҪ�Ƚ��ѣ�
		void heapSort(int[] array){
			for(int i = array.length-1;i>0;i--){
				int temp = array[0];
				array[0] = array[i];
				array[i] = temp;
				maxHeapify(array, i, 0);
			}
		}
}
