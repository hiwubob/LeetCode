package StackandQueue;

import java.util.LinkedList;

public class GetMaxWindow {
    public int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();//记录下标
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
//            qmax不为空，或者最为j，arr[j]<=arr[i],把最后一个取出，保证qmax从大到小
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            //qmax为空直接把下标i放入
            qmax.addLast(i);
            if (qmax.peekFirst() < i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        GetMaxWindow g = new GetMaxWindow();
        int[] res = g.getMaxWindow(arr, w);
        for (int r :
                res) {
            System.out.print(r + ",");
        }
    }
}
