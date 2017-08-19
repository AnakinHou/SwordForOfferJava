package problem40;
/*
 * ������40��������ֻ����һ�ε�����
 * һ�������г�����������֮�⣬�������ֶ����������Σ��ҳ�����������������������{2,4,3,6,3,2,5,5}����Ϊֻ��4��6��������ֻ����һ�Σ����������������Σ��������4��6��
 * ˼·������Ƚ�ƫ�����������������ʣ��κ�һ����������Լ�������0�������ͷ��β������������е�ÿһ�����֣���ô���ս���պ����ĸ�ֻ����һ�ε����֣���Ϊ�ɶԳ��ֵ�����ȫ��������е����ˡ�
 * ����ģ�����ܹ���ԭ�����Ϊ���������飬��ÿ���������У�����һ��ֻ����һ�ε����֣����������ֶ��������Ρ�����ܹ��������ԭ���飬����ǰ��İ취���Ƿֱ����������ֻ����һ�ε������ˡ����ǻ��Ǵ�ͷ��β������������е�ÿһ�����֣���ô���յõ��Ľ����������ֻ����һ�ε����ֵ���������������������ֿ϶���һ������ô���������϶���Ϊ0��Ҳ����˵���������Ķ����Ʊ�ʾ��������һλΪ1�������ڽ���������ҵ���һ��Ϊ1��λ��λ�ã���Ϊ��Nλ�����������Ե�Nλ�ǲ���1Ϊ��׼��ԭ�����е����ֳַ����������飬��һ����������ÿ�����ֵĵ�Nλ��Ϊ1�����ڶ����������ÿ�����ֵĵ�Nλ��Ϊ0�����������Ѿ���ԭ����ֳ������������飬ÿ�������鶼����һ��ֻ����һ�ε����֣����������ֶ����������Ρ�
 */
public class FindNumsAppearOnce {
	public void findNumsAppearOnce(int[] array){
		if(array == null)
			return ;
		int number = 0;
		for(int i : array)
			number ^= i;
		int index = findFirstBitIs1(number);
		int number1 = 0;
		int number2 = 0;
		for(int i : array){
			if(isBit1(i,index))
				number1 ^= i;
			else
				number2 ^= i;		
		}
		System.out.println(number1);
		System.out.println(number2);
	}
	//�ҵ�number�����Ʊ�ʾ�����ұ�1����λ��
	private int findFirstBitIs1(int number){
		int indexBit = 0;
		while((number & 1) == 0){
			number = number >> 1;
			indexBit++;
		}
		return indexBit;
	}
	//�ж���number�Ķ����Ʊ�ʾ�д��ұ������indexλ�ǲ���1
	private boolean isBit1(int number,int index){
		number = number >> index;
		return (number & 1) == 0;
	}
	public static void main(String args[]){
		FindNumsAppearOnce test = new FindNumsAppearOnce();
		int[] array = {2,4,3,6,3,2,5,5};
		test.findNumsAppearOnce(array);
	}
}
