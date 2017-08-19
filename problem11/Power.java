package problem11;
/*
 * ������11����ֵ�������η�
 * ʵ�ֺ���double Power(double base,int exponent)����base��exponent�η�������ʹ�ÿ⺯�������ÿ��Ǵ������⡣
 * ע�⣺�ж�����С���Ƿ���Ȳ�����==����Ϊ�������ʾС����������ֻ���ж����ǲ�ľ���ֵ�Ƿ���һ����С�ķ�Χ�ڡ�
 * ���⻰���������������ַ���������ֵ��ȫ�ֱ������쳣������ֵ�ô��Ǹ��ݷ���ֵ�жϴ���ԭ��ȱ���Ǻ���ֻ�ܷ���һ��ֵ��ʹ�ò��㡣ȫ�ֱ�������ռ�ú������ؽ�����쳣���������ˣ�����Щ���Բ�֧�֡�
 */
public class Power {
	private double power(double base,int exponent) throws Exception{
		double result = 0.0;
		if(equal(base,0.0) && exponent<0){
			throw new Exception("0�ĸ�������������");
		}
		if(exponent == 0){//����0��0�η�û�����壬����0��1������
			return 1.0;
		}
		if(exponent > 0){
			result = powerWithExponent(base, exponent);
		}else{//��������
			result = powerWithExponent(1.0/base, -exponent);
		}
		return result;
	}
	//������
	private double powerWithExponent(double base,int exponent){
		double result = 1.0;
		for(int i=1;i<=exponent;i++){
			result = result * base;
		}
		return result;
	}
	//�ж�����С���Ƿ����
	private boolean equal(double num1,double num2){
		if( ((num1-num2) > -0.0000001) && (num1-num2) < 0.0000001 ){
			return true;
		}else return false;
	}
	public static void main(String[] args) throws Exception {
		Power test = new Power();
		System.out.println(test.power(2, 3));
	}
}
/*
 * ���ϳ���ļ�����̲�����Ч����ߵģ���Ϊ������32�η���Ҫѭ��31�Σ�����������Ѿ������16�η�����ƽ��һ�ξͺ��ˣ���16������8��ƽ�����Դ����ƣ�
 * ����Ϊ��nΪż��ʱ��a^n=a^(n/2)*a^(n/2)��nΪ����ʱ��a^n=a^((n-1)/2)*a^((n-1)/2)*a������������٣������õݹ�ʵ�֣����Ӷȴ�O(n)�����O(logn)��
 * ϸ�ڣ�������������������2���������������ȡ�����ж���ż����Ϊλ�����Ч�ʸߺܶࡣ�������£�
 */ 
//private double powerWithExponent2(double base,int exponent){
//	if(exponent == 0) return 1;
//	if(exponent == 1) return base;//�����ݹ���ֹ������
//	double result = powerWithExponent2(base, exponent >> 1);//������1λ�����2
//	result *= result;
//	if( (exponent & 1) == 1) result *= base;//���������λΪ1����Ϊ����
//	return result;
//	//�����루2��6��Ϊ������˵������ʼ�󣬽����һ�εݹ飬����Ϊ��2��3��
//	//Ȼ�����ڶ��εݹ飬����Ϊ��2��1������ʱexponentΪ1������baseΪ2��Ҳ����˵�ڶ��εݹ��ִ�н��Ϊ2
//	//Ȼ��ص��˵�һ�εݹ飬��ͷ��resultֵΪ�ڶ��εݹ�Ľ��2��Ȼ������ִ�У�resultΪ2*2����һ�εݹ�ʱexponentΪ3��result=4*2������8
//	//���Ե�һ�εݹ��ִ�н��Ϊ8��Ȼ��ص�ԭ��������ͷ��resultΪ8��Ȼ��ִ��8*8����ʱexponentΪ6�����ս������64��
//}
