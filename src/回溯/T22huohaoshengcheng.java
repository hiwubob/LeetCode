package »ØËİ;

import java.util.ArrayList;
import java.util.List;

public class T22huohaoshengcheng {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> res = new ArrayList<String>();
		generate(res,"",0,0,n);
		return res;
	}

	private void generate(ArrayList<String> res, String ans, int count1, int count2, int n) {
		if(count1>n || count2>n)
			return;
		if(count1==n && count2==n)
			res.add(ans);
		if(count1>=count2) {
			String ans1=new String(ans);
			generate(res, ans1+"(", count1+1, count2, n);
			generate(res, ans1+")", count1, count2+1, n);
		}
	}
}
