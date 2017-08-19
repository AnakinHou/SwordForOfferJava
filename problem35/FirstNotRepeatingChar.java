package problem35;

import java.util.LinkedHashMap;

/*
 * ������35����һ��ֻ����һ�ε��ַ�
 * �������롰abaccdeff�������b��
 * ˼·����ͷ��β����ɨ��϶��ǲ��еģ����Ӷ�O(n^2)̫���ˡ������ù�ϣ���ռ任ʱ�䡣
 * �����Ŀ1�����������ַ������ӵ�һ���ַ�����ɾ���ڵڶ����ַ����г��ֹ����ַ��������ù�ϣ���洢�ڶ����ַ����е��ַ���Ȼ��ɨ���һ���ַ�������O(1)��ʱ������ж��ַ��ڲ��ڵڶ����ַ������ʱ�临�Ӷ�O(n)��
 * �����Ŀ2��ɾ���ַ����������ظ����ֵ��ַ����������롰google���������gole���������Ǵ�ͷ��βɨ�裬��һ�γ��ֵķŽ���ϣ�У�Ȼ���ظ����ֵĲ����ˡ�
 * �����Ŀ3��������������г��ֵ���ĸ��ͬ������ÿ����ĸ���ֵĴ���Ҳ��ͬ����ô���������ʻ�Ϊ��λ�ʡ�����evil��live�������ж�ʱ�����ù�ϣ��keyΪ���ֵ���ĸ��valueΪ���ִ�����
 */
public class FirstNotRepeatingChar {
	public Character firstNotRepeatingChar(String str){
		if(str == null){
			return null;
		}
		char[] chars = str.toCharArray();
		LinkedHashMap<Character, Integer> hash = new LinkedHashMap<Character, Integer>();
		for(char item : chars){
			if(hash.containsKey(item)){
				hash.put(item, hash.get(item)+1);
			}else{
				hash.put(item, 1);
			}
		}
		// ����LinkedHashMapֻ��HashMap�Ļ�������ʹ��ˣ���Ϊ˳��һ����
		for(char key : hash.keySet()){
			if(hash.get(key) == 1)
				return key;
		}
		return null;
	}
	public static void main(String[] args) {
		FirstNotRepeatingChar test = new FirstNotRepeatingChar();
		System.out.println(test.firstNotRepeatingChar("abaccdeff"));
	}
}
