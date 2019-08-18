package Kproblem;

public class topkquicksort {
//    最小 k 个数
//    快速排序的思想

    public void getTopKMinBySort(int a[], int k) {
        getTopKMinBySort(a, 0, a.length - 1, k);
    }

    public void getTopKMinBySort(int a[], int first, int end, int k) {
        if (first < end) {
            int partionIndex = partion(a, first, end);
            if (partionIndex == k - 1) {
                return;
            } else if (partionIndex > k - 1) {
                getTopKMinBySort(a, first, partionIndex - 1, k);
            } else {
                getTopKMinBySort(a, partionIndex + 1, end, k);
            }
        }
    }
    public int partion(int a[], int first, int end) {
        int key = a[first];
        while (first < end) {
            while (first < end && a[end] >= key) {
                end--;
            }
            a[first]=a[end];
            while (first<end&&a[first]<=key){
                first++;
            }
            a[end] = a[first];
        }

        a[first]=key;
        return first;
    }

    public static void main(String []args){
        int a[]={2,20,3,7,9,1,17,18,0,4};
        int k=6;
        new topkquicksort().getTopKMinBySort(a,0,a.length-1,k);
        for(int i=0;i<k;i++){
            System.out.print(a[i]+" ");
        }
    }
}

