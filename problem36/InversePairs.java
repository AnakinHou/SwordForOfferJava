package problem36;
/*
 * ������36�������е������
 * �����е��������֣����ǰ��һ�����ں��һ���������һ������ԡ���{7��5��6��4}����5������ԣ��ֱ���(7,6)��(7,5)��(7,4)��(6,4)��(5,4)��
 * ˼·����ÿһ��Ԫ�ض���ͷ��βɨ���O(n^2)�ķ����ǲ��õģ�������{7��5��6��4}Ϊ������һ�ָ��Ӷȵ͵ķ�����
 * �Ȱ����鲻�ϵض԰�֣�ֱ�������鳤��Ϊ1��������һ�ߺϲ����ڵ������飬һ��ͳ������ԡ�����7��5�������ԣ�6��4Ҳ�ǣ���ͳ������֮�������ԣ���֮ǰҪ�����������ظ�ͳ�ƣ���ʵ������⣬�������
 */
public class InversePairs {
	
	// tmpΪ��ʱ���飬leftEnd��rightEnd�ֱ�ָ��ǰ��κͺ������һ�����֣�leftBegin��rightBegin��ʾ���ο�ʼλ��
	private static int merge(int[] arr, int[] tmp, int leftBegin, int rightBegin, int rightEnd){
        int leftEnd = rightBegin - 1;
        int tmpEnd = rightEnd; // ָ����ʱ�������һλ
        int length = rightEnd - leftBegin + 1; // ����һ���ĳ���
        int count = 0; // �������Ŀ
        while (leftBegin <= leftEnd && rightBegin <= rightEnd) {
        	// ���ǰ������һ����С�ڵ��ں������һ��������������������������ԣ��Ѻ������һ�������������飬ͬʱrightEndǰ��һλ��
            if (arr[leftEnd] <= arr[rightEnd]) {
                tmp[tmpEnd--] = arr[rightEnd--];
            }else {
            	// ���ǰ������һ�����Ⱥ������һ������˵��ǰ������һ�����Ⱥ��������������������ĿΪ���γ��ȡ�
            	// Ȼ���ǰ������һ������������������һ��������������������򣩣�ͬʱleftEndǰ��һλ��
                tmp[tmpEnd--] = arr[leftEnd--];
                count += rightEnd - rightBegin + 1;
            }
        }
        // ���ĳһ���Ѿ�ȫ�����������飬���ڰ���һ�ΰ�˳��Ž������顣
        while (leftBegin <= leftEnd) {
            tmp[tmpEnd--] = arr[leftEnd--];
        }
        while (rightBegin <= rightEnd) {
            tmp[tmpEnd--] = arr[rightEnd--];
        }
        // ����ԭ����
        for (int i = 0; i < length; i++, leftBegin++) {
            arr[leftBegin] = tmp[leftBegin];
        }
        return count;
    }
	
	// left��right�Ƿֶκ����ʼ����ֹλ�á�leftCount��ǰһ���ڲ����������Ŀ��rightCount�Ǻ��εģ�count������֮��ġ�
    private static int InversePairesCore(int[] arr, int[] tmp, int left, int right){
        int leftCount = 0;
        int rightCount = 0;
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            leftCount = InversePairesCore(arr, tmp, left, mid);
            rightCount = InversePairesCore(arr, tmp, mid+1, right);
            count = merge(arr, tmp, left, mid+1, right);
        }
        return leftCount + rightCount + count;
    }
    // ���
    public int inversePaires(int[] arr){
        if (arr == null || arr.length <= 0) {
            return 0;
        }
        // ��ʱ���鱣���������м�����Ȼ���ٸ�ֵ��ԭ���顣
        int[] tmp = arr.clone();
        int count = InversePairesCore(arr, tmp, 0, arr.length - 1);
        return count;
    }
    // ������
    public static void main(String[] args) throws Exception {
        InversePairs test = new InversePairs();
        System.out.println(test.inversePaires(new int[]{7,5,6,4}));
    }
}
