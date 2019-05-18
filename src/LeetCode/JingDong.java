package LeetCode;

import java.util.HashMap;
import java.util.Scanner;

public class JingDong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int result=0;

		HashMap<Integer,Integer> map=new HashMap<>();
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			if(nums[i]>max)
				max=nums[i];
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
		}
		
		if(map.get(max)>=2) {
			result=n-2+(n-map.get(max))*(n-map.get(max)-1)/2;
		}else if(n<=3){
			result=1;
		}else {
			result=0;
		}
		System.out.println(result%998244353);
	}
}
