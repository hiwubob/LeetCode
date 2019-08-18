package Kproblem;

public class topkdump {
    public static void main(String[] args) {
        int[] m={0,7,9,10,1,2,3,4,5,6};
        int k=6;
        new topkdump().topk(m,k);
    }
    public void topk(int[] m, int k) {
        int[] n = new int[k];
        for (int i = 0; i < k; i++) {
            n[i]=m[i];
        }
        heapSort(n);
        for (int i = k; i <m.length ; i++) {
            if (m[i] >n[0]) {
                n[0]=m[i];
                heapSort(n);
            }
        }
        for (int a:n
             ) {
            System.out.print(a+" ");
        }

    }

    public void heapSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            creatHeap(a, a.length - 1 - i);
            swap(a, 0, a.length - 1 - i);
        }
    }

    private void creatHeap(int[] a, int last) {
        for (int i = (last-1)/2; i >=0 ; i--) {
            int k=i;
            while (2 * k + 1 <= last) {
                int big=2*k+1;
                if (big + 1 <= last) {
                    if (a[big] <a[big + 1]) {
                        big++;
                    }
                }
                if (a[k] < a[big]) {
                    swap(a, k, big);
                    k = big++;
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        if (i == j) {
            return;
        }

        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
