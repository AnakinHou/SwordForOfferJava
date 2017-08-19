package problem45;

import java.util.ArrayList;

/*
 * ������45��ԲȦ�����ʣ�µ�����(Լɪ������)
 * 0,1...n-1��n�������ų�һ��ԲȦ���ӵ�һ���˿�ʼ����������m���˳��֣�Ȼ�����һ���˿�ʼ�����������ȦȦ��ʣ�µ����һ�����֡�
 * ˼·������ArrayListģ������Ū��һ��Ȧ��ɾ������ʣһ����ʱ������������
 */
public class LastRemaining {
	static int lastRemaining(int n, int m) throws Exception{
		if(n < 1 || m < 1)
			throw new Exception("wrong");
		ArrayList<Integer> cirList = new ArrayList<>();
		for(int i=0;i<n;i++)
			cirList.add(i);
		int cur = 0; // ��ʼλ���±�
		while(cirList.size() > 1)
			cur = deleteCirList(cirList, m, cur);
		return cirList.get(0);
	}
	//m�ǲ�����cur�Ǵ�˭��ʼ�������������һ�Σ�����ÿ�ο�ʼʱ���±��1����󷵻ر�ɾ���ߵ��±꣬Ҳ����һ�ֿ�ʼ���±ꡣ
	static int deleteCirList(ArrayList<Integer> list, int m, int cur){
		int tmp = cur-1;
		for(int i=0;i<m;i++){
			tmp++;
			if(tmp == list.size())
				tmp = 0;
		}
		list.remove(tmp);
		return tmp;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(lastRemaining(5, 3));
	}
}
