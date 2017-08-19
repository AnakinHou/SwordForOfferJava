package problem14;

import java.util.Arrays;
/*
 * ������14��ʹ����������λ��ż��ǰ
 * ����һ���������飬ʵ��һ�����������������е����ֵ�˳��ʹ����������λ�������ǰ�벿�֣�ż��λ�ں�벿�֡�
 * ˼·��ǰ���һ��ָ���໥���������ǰż���棬����λ�ã�ֱ������ָ�����������Ӷ�O(n)��
 * ע�⣺�����Ŀ���ɸ���������ǰ�ߣ����ܱ�3�������ڲ��ܵ�ǰ�ߵȣ�ֻ���ж������ı䣬�������ǰ��жϹ��ܷ��������ÿ��ֻ�޸�������ܾ����ˡ�
 */
public class Reorder {
	static boolean yesOrNo(int number){//�ǲ���ż��
		boolean tag = true;//��ż��������
		if( (number & 1) == 1 ){//���������ؼ�
			tag = false;
		}
		return tag;
	}
	static void reorder(int[] array){
		if(array.length == 0){
			System.out.println("����Ϊ��");
			return;
		}
		int left = 0;
		int right = array.length - 1;//ǰ���һ��ָ��
		while(left < right){
			while( (left < right) && !yesOrNo(array[left]) ){//����ǰ�ߵ�����
				left++;
			}
			while( (left < right) && yesOrNo(array[right]) ){//������ߵ�ż��
				right--;
			}
			if(left < right){//����
				int temp = array[right];
				array[right] = array[left];
				array[left] = temp;
			}
		}
	}
	public static void main(String[] args) {
		int[] test = {2,4,5,6,1,3,9};
		reorder(test);
		System.out.println(Arrays.toString(test));
	}
}
