package problem46;
/*
 * ������46����1+2+...+n
 * Ҫ����ʹ�ó˳�����ѭ�����ж���䡣
 */
public class SumSolution {
	public static int sum = 0;
    public static boolean sumSolution(int n) {
        sum += n;
        return n != 1 && sumSolution(n - 1);
    }
    public static void main(String[] args) {
        sumSolution(100);
        System.out.println(SumSolution.sum);
    }
}
