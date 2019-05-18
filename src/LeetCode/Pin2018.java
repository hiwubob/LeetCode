package LeetCode;

import java.util.Scanner;

public class Pin2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int[] nums = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
		}
		System.out.println(max(nums));
	}

	private static int max(int[] nums) {
		int max1=Integer.MAX_VALUE;
		int max2=Integer.MAX_VALUE;
		int max3=Integer.MAX_VALUE;
		int min1=Integer.MIN_VALUE;
		int min2=Integer.MIN_VALUE;
		for(int n:nums) {
			if(n>max1) {
				max3=max2;
				max2=max1;
				max1=n;
			}else if(n>max2) {
				max3=max2;
				max2=n;
			}else if(n>max3) {
				max3=n;
			}
			
			if(n<min1) {
				min2=min1;
				min1=n;
			}else if(n<min2) {
				min2=n;
			}
		}
		return Math.max(max1*max2*max3, max1*min1*min2);
	}
}
