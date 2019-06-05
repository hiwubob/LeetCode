package Sort;

public class insertSort {
    public void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j;
            for (j = i - 1; j >= 0 && a[j] > tmp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }

    public void insert2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                a[j + 1] = a[j + 1] + a[j];
                a[j] = a[j + 1] - a[j];
                a[j + 1] = a[j + 1] - a[j];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 4, 7, 3, 8, 3};
        insertSort s = new insertSort();
        s.insert2(a);
        for (int b : a) {
            System.out.print(b);
        }
    }
}
