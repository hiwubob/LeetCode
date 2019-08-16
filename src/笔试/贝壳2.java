package 笔试;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Scanner;

public class 贝壳2 {
    //最长严格上升子序列
    private static int getLength(int[] array) {
        int[] assistArray = new int[array.length];
                assistArray[0] = array[0];
                int length = 0;
                for (int number : array) {
                    if (assistArray[length] < number) {
                        assistArray[++length] = number;
                    } else {
                int low = 0;
                int high = length;
                while (low < high) {
                    int middle = (low + high) >> 1;
                    if (assistArray[middle] < number) {
                        low = middle + 1;
                    } else {
                        high = middle - 1;
                    }
                }
                if (assistArray[low] < number && (low + 1) < assistArray.length) {
                    assistArray[low + 1] = number;
                } else {
                    assistArray[low] = number;
                }
            }
        }
        return length + 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int[] number = new int[N];
            for (int i = 0; i < N; i++) {
                number[i] = sc.nextInt();
            }
            System.out.println(getLength(number));
        }

    }

}

