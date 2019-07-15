package Huisu;

import java.util.ArrayList;
import java.util.List;

public class T17µç»°ºÅÂë {
	static String[] a = new String[] {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	static StringBuffer sb=new StringBuffer();
	public static List<String> letterCombinations(String digits){
		List<String> res=new ArrayList<String>();
		if(digits.length()==0)
			return res;
		zuhe(digits,0,res);
		return res;
	}
	private static void zuhe(String digits, int n, List<String> res) {
		if(n==digits.length()) {
			res.add(sb.toString());
			return;
		}
		
		for(int i=0;i<a[digits.charAt(n)-'0'].length();i++) {
			sb.append(a[digits.charAt(n)-'0'].charAt(i));
			zuhe(digits,n+1,res);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void main(String[] args) {
		String s="23";
		List<String> list=new ArrayList<>();
		list=letterCombinations(s);
		System.out.println(list);
	}
}
