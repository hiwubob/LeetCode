package Sort;

import java.util.ArrayList;
import java.util.Collections;


public class bucketSort {
    public static void bucketSort(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                System.out.print(bucketArr.get(i).get(j)+ " ");
            }
        }

    }

    public static void main(String[] args) {
        bucketSort b= new bucketSort();
        int[] a={2,6,7,4,8,3};
        b.bucketSort(a);
//        for (int num :
//                a) {
//            System.out.print(num);
//        }

    }

}