package LeetCode;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;

public class TainJiSaiMa2 {
	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] A = new int[n];
		int[] B = new int[n];

		for (int i = 0; i < n; ++i) {
			A[i] = in.nextInt();
		}
		for (int i = 0; i < n; ++i) {
			B[i] = in.nextInt();
		}

		Arrays.sort(A);
		Arrays.sort(B);

		int i = 0, j = 0, x = n - 1, y = n - 1, count = 0;
		boolean bLast = true;

		while (bLast) {

			if (x == i)
				bLast = false;

			if (A[x] > B[y]) {
				x--;
				y--;
				count += 100;
			} else if (A[i] > B[j]) {
				i++;
				j++;
				count += 100;
			} else {
				if (A[i] < B[y])
					count -= 100;
				i++;
				y--;
			}
		}
		System.out.println(count);

	}
}
