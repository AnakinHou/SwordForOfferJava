package problem29;
/*
 * ������29�������г��ִ�������һ�������(�漰����)
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���������֡�
 * ˼·1�����ÿ��Ű������ź���Ȼ���м���Ǹ������ǳ��ִ������ģ����Ÿ��Ӷ�ΪO(nlogn)����ʵ���У����ǲ���һ������ɿ��ţ�ֻ�����һ�ֺ�������ѡ��Ŀ��ŵ�key���ڵ��±��ǲ��������м��������ˡ��ܸ��Ӷ�O(n)�����ַ������޸����飬���Ҫ���Ƿ������������������ǲ��ȶ�������
 * ˼·2�����Ӷ�Ҳ��O(n)�Ҳ����޸����飬�����Ǹ��������ص㣺����һ����¼���ִ����ı�������ʼΪ1��Ȼ���ͷ��ʼ�����������������һ������ͬ��������һ����֮��һ���������Ϊ0��������һ����ΪҪ���ص��������Ѵ�����Ϊ1����ΪҪ�ҵ����ֱ��������������࣬����Ҫ�ҵ����־������һ�ΰѴ�����Ϊ1ʱ��Ӧ�����֡�
 */
public class MoreThanHalfNum {
	public static void main(String[] args) {
		MoreThanHalfNum test = new MoreThanHalfNum();
		test.moreThanHalfNum1(new int[]{1,8,5,2,2,2,2});
		test.moreThanHalfNum2(new int[]{2,4,2,6,6,6,6});
	}
	//˼·1�����ŵ�˼��
	private void moreThanHalfNum1(int[] array){
		if(array == null){
			return ;
		}
		int middleIndex = array.length >> 1;//�м�λ���±꣬������1λ�������2
		int left = 0;
		int right = array.length-1;
		int keyIndex = partition(array, left, right);//����һ�ο��ź���ѡkey���±ꡣ
		while(keyIndex != middleIndex){//ֱ����������ѡkey���±����ԭ�����м�λ���±�
			if(keyIndex > middleIndex){
				right = keyIndex - 1;
				keyIndex = partition(array, left, right);
			}else{
				left = keyIndex + 1;
				keyIndex = partition(array, left, right);
			}
		}
		if( check(array,array[keyIndex]) ){//��������������㡰ĳ��������һ�롱
			System.out.println(array[keyIndex]);
		}else{
			System.out.println("û�г���һ�����");
		}
	}
	//˼·2�����������ص�
	private void moreThanHalfNum2(int[] array){
		if(array == null){
			return ;
		}
		int count = 1;
		int number = array[0];
		for(int i = 1;i<array.length;i++){
			if(count == 0){
				number = array[i];
				count = 1;
			}else if(array[i] != number){
				count--;
			}else{
				count++;
			}
		}
		if( check(array,number) ){
			System.out.println(number);
		}else{
			System.out.println("û�г���һ�����");
		}
	}
	//ע�����ǲ��Ŀ����е�һ������
	private Integer partition(int[] array,int left,int right){
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
		return i;//������ѡkey����һ���������±�
	}  
	private boolean check(int[] array,int number){
		int times=0;
		boolean isMoreThanHalf = false;
		for(int i=0;i<array.length;i++){
			if(array[i]==number){
				times++;
			}
		}
		if(times*2 > array.length){
			isMoreThanHalf = true;
		}
		return isMoreThanHalf;
	}
}
