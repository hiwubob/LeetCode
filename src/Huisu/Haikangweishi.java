package Huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Haikangweishi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int[] count = new int[map.size()];
		int i = 0;
		for (int value : map.values()) {
			count[i] = value;
			i += 1;
		}

		Arrays.sort(count);
		int min = count[0];
		for (int j = min; j >= 2; j--) {
			int cnt = 0;
			for (int k = 0; k < count.length; k++) {
				if (count[k] % j == 0) {
					cnt++;
				}
			}
			if (cnt == count.length) {
				System.out.println(n / j);
				;
			} else {
				System.out.println(0);
			}
		}
	}
}
