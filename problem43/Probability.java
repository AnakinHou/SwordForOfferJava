package problem43;
/*
 * ������43��n�����ӵĵ���(��̬�滮)
 * ��n�����ӣ��������ӳ���һ��ĵ���֮��Ϊs,����n,��ӡ��s�����п��ܵ�ֵ���ֵĸ��ʡ�
 * ˼·��n�����Ӻ���СΪ�㣬���Ϊ6n������������ϣ�n�����ӵ����е���������Ϊ6^n��������Ҫ��ͳ�Ƴ�ÿһ�ֵ����͵ĳ��ִ�����Ȼ�����6^n��Ϊ���ʡ���̬�滮�������£�
 * ����n�����ӣ�������Ϊs����ÿһ�ֵ����ͳ��ֵĴ�����Ϊf(n,s)�����ڼ�������n-1�����ӣ�������һ�����ӣ����ĵ���ֻ����1��6����n�����ӵõ�������Ϊs�������6�֣�����f(n,s)=f(n-1,s-1)+f(n-1,s-2)+...+f(n-1,s-6)������һ������ʱ��f(1,1)=f(1,2)=f(1,3)=f(1,4)=f(1,5)=f(1,6)=1��
 * ���嵽�������������飬�ڵ�һ��ѭ���У���һ�������еĵ�s�����ֱ�ʾ��Ϊs���ֵĴ���������һ��ѭ���У�����һ�������ӣ���ʱ��Ϊs���ֵĴ���������һ��ѭ���к�Ϊs-1,s-2,s-3ֱ��s-6���ִ������ܺͣ����԰���һ������ĵ�s��������Ϊǰһ�������Ӧ�ĵ�s-1,s-2,s-3ֱ��s-6֮�ͣ���һ��ѭ�����������ظ���һ���̡�
 */
public class Probability {
    
    static void printProbability(int number){
        if (number<1)
            return;
        int g_maxValue = 6;
        int[][] pProbabilitys = new int[2][g_maxValue * number + 1];
        int flag = 0; // ������2��������л�
        // һ������ʱ
        for (int i = 1; i <= g_maxValue; i++)
            pProbabilitys[flag][i] = 1;
        // ��ʼ������
        for (int k = 2; k <= number; k++) {
        	// �����ܳ��ֵĴ������Ϊ0
            for (int i = 0; i < k; i++)
                pProbabilitys[1-flag][i] = 0;
            // ���ܳ��ֵĴ���
            for (int i = k; i <= g_maxValue*number; i++) {
                pProbabilitys[1-flag][i] = 0;
                for (int j = 1; j <= i && j <= g_maxValue; j++) 
                    pProbabilitys[1-flag][i] += pProbabilitys[flag][i-j];                
            }
            flag = 1-flag;
        }
        double total = Math.pow(g_maxValue, number);
        for (int i = 1; i <= g_maxValue*number; i++) {
            double ratio = pProbabilitys[flag][i] / total;
            System.out.println(i + ": " + ratio);
        }
    }

	public static void main(String[] args) {
		printProbability(1);
	}
}
