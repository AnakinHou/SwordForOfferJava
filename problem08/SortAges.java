package problem08;

import java.util.Arrays;

public class SortAges {
	//������Ա���������������Ҫ���Ӷ�O(n)��
	//�����ص������е����ִ�С��һ��С��Χ�ڣ�������0-99,ʹ�ø����ռ䣩
	private void sortAges(int ages[]){
		if(ages.length == 0) System.out.println("����Ϊ��");
		int oldestAge = 99;//�������99
		int timesOfAge[] = new int[oldestAge+1];//����ÿ��������ֵĴ���
		for(int i=0;i<=oldestAge;i++){
			timesOfAge[i] = 0;//��ʼ��Ϊ0
		}
		for(int i=0;i<ages.length;i++){
			if(ages[i] < 0 || ages[i] > oldestAge){
				System.out.println("��������Խ��");
				return;
			}else{
				timesOfAge[ages[i]]++;//��������ִ�����1
			}
		}
		//��ʼ����������
		int index = 0;
		for(int i=0;i<=oldestAge;i++){
			for(int j=0;j<timesOfAge[i];j++){
				ages[index] = i;
				index++;
			}
		}
	}
	public static void main(String[] args) {
		SortAges test = new SortAges();
		int a[] = {14,25,22,44,29,44,88};
		test.sortAges(a);
		System.out.println(Arrays.toString(a));
	}
}
