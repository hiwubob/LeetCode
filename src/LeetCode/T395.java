package LeetCode;

public class T395 {
	public int longestSubstring(String s, int k) {
		if(k<=1)
			return s.length();
		char[] arr=s.toCharArray();
		int size=0;
		for(int i=0;i<s.length();i++) {
			int[] mip=new int[26];
			mip[arr[i]-'a']++;
			for(int j=i+1;j<s.length();j++) {
				mip[arr[j]-'a']++;
				if(arrBiggerK(mip,k)&& j-i+1>size) {
					size=j-i+1;
				}
			}
		}
		return size;
	}

	private boolean arrBiggerK(int[] mip, int k) {
		for(int c:mip) {
			if(c>0 && c<k)
				return false;
		}
		return false;
	}
}
