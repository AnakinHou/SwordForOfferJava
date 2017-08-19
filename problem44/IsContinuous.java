package problem44;

import java.util.Arrays;

/*
 * ������44���˿��Ƶ�˳��
 * ��һ�����������ȡ5���ж��ǲ���˳�ӣ�AΪ1����С����Ϊ����ֵ��
 * ˼·����5���ƿ��ɴ�СΪ5�����飬��С����Ϊ0�����Ȱ�����������ͳ��������0�ĸ�������Ҫͳ��������������������֮��Ŀ�ȱ����ȥ��0�ĸ�����ȣ�0�ȿ�ȱ����Ļ�����˳�ӡ�
 */
public class IsContinuous {
	static boolean isContinuous(int[] arr) {
        if (arr == null || arr.length < 1)
            return false;
        int length = arr.length;
        Arrays.sort(arr);
        int numbersOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < length && arr[i] == 0; i++)
            ++numbersOfZero;
        int notZeroIndex = numbersOfZero;
        while (notZeroIndex < length-1) {
        	// ���ظ������϶�����˳��
            if (arr[notZeroIndex] == arr[notZeroIndex+1])
                return false;
            numberOfGap += arr[notZeroIndex+1] - arr[notZeroIndex] - 1;
            notZeroIndex++;
        }
        return numberOfGap > numbersOfZero ? false : true;
    }
    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{2,4,5,0,0}));
    }
}
