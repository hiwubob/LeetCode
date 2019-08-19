package ±  ‘;

import java.util.Scanner;

public class QQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int[] arr = new int[(int) Math.pow(2, N1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int N2 = sc.nextInt();
        for (int i = 0; i < N2; i++) {
            rev(arr, sc.nextInt());

            int[] tmparr = new int[(int) Math.pow(2, N1)];
            for (int j = 0; j < arr.length; j++) {
                tmparr[j] = arr[j];
            }
            QQ2 xx = new QQ2();
            xx.cnt = 0;
            System.out.println(xx.InversePairs(tmparr));
        }

    }

    private static void rev(int[] arr, int i) {
        int index = 0;
        int gap = (int) Math.pow(2, i);
        while (index < arr.length) {
            int n = index, m = index + gap - 1;
            while (n < m) {
                swapArray(arr, n, m);
                n++;
                m--;
            }
            index += gap;
        }
    }

    private static void swapArray(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    private long cnt;
    private int[] tmp;

    public long InversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int l, int h) {
        if (h - l < 1)
            return;
        int m = l + (h - l) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, h);
        merge(nums, l, m, h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        int i = l, j = m + 1, k = l;
        while (i <= m || j <= h) {
            if (i > m)
                tmp[k] = nums[j++];
            else if (j > h)
                tmp[k] = nums[i++];
            else if (nums[i] <= nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                this.cnt += m - i + 1;
            }
            k++;
        }
        for (k = l; k <= h; k++)
            nums[k] = tmp[k];
    }
}