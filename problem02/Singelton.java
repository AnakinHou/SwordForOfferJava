package problem02;
/*
 * ������2��дһ������ģʽ��
 * ����ģʽ�������ص㣺1��������ֻ����һ��ʵ����
 * 2������������Լ������Լ���Ψһʵ����
 * 3�������������������������ṩ��һʵ����
 * ��֮��ѡ����ģʽΪ�˱��ⲻһ��״̬�����ӡ����
 */
//������һ�ֶ���ʽд�������ഴ����ͬʱ���Ѿ�������һ����̬�Ķ���ϵͳʹ�ã��Ժ��ٸı䣬�����������̰߳�ȫ��,ȱ����ռ���ڴ档
//����ģ�1������һ���࣬���캯����private�ġ�
//2���������һ��private static final�ĸ�������������ʼ��ʱʵ������
//3��ͨ��һ��public static��getInstance������ȡ���������ã��̶��������ķ�����
public class Singelton {
	private Singelton(){}
	private static final Singelton instance = new Singelton();
	public static Singelton getInstance(){
		return instance;
	}
}
//����������ʽ�����࣬�ڵ�һ�ε��õ�ʱ��ʵ������
class Singleton2{
	private Singleton2(){};
	//ע������û��final��ֻ�ǳ�ʼ����
	private static Singleton2 instance = null;
	//����ʱʵ������ʹ��synchronized������̷߳���ʱ������ɵ��ظ�ʵ��������
	public static synchronized Singleton2 getInstance(){
		if(instance == null){
			instance = new Singleton2();
		}
		return instance;
	}
}