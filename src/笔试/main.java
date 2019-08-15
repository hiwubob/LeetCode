package ±  ‘;


public class main {
    //    ≤Â»Î
    public void insertSort(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            for (int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--) {
                swap(a, j, j + 1);
            }
        }
    }

    public void shellSort(int[] a) {
        for (int gap = a.length/2; gap >0 ; gap--) {
            for (int i = gap; i <a.length ; i++) {
                for (int j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    swap(a,j,j+gap);
                }
            }
        }
    }
    //    —°‘Ò
    public void selectSort(int[] a) {
        int min;
        for (int i = 0; i < a.length; i++) {
            min=i;
            for (int j = i+1; j < a.length; j++) {

                if (a[j] < a[min]) {
                    min=j;
                }
            }
            swap(a,i,min);

        }
    }

    public void heapSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            heapSort(a, a.length - 1 - i);
            swap(a,0,a.length-1-i);
        }
    }

    private void heapSort(int[] a, int last) {
        for (int i = (last - 1) / 2; i >= 0; i--) {
            int k=i;
            while (2 * k + 1 < last) {
                int big=2*k+1;
                if (big + 1 < last) {
                    if (a[big] < a[big + 1]) {
                        big++;
                    }
                }

                if (a[k] < a[big]) {
                    swap(a, k, big);
                    k = big;
                } else {
                    break;
                }
            }
        }
    }


    public void bubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public void quickSort(int[] a) {
        quickSort(a,0,a.length-1);
    }

    private void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = getMid(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a,low,mid+1);
        }
    }

    private int getMid(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] >= key) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= key) {
                low++;
            }
            a[high] = a[low];
        }
        a[low]=key;
        return low;
    }


    public void mergeSort(int[] a) {
        mergeSort(a,0,a.length-1);
    }

    private void mergeSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            mergeSort(a,low,mid,high);
        }
    }

    private void mergeSort(int[] a, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int i=low;
        int j=mid+1;
        int k=0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j ++];
            }
        }

        while (i <= mid) {
            tmp[k ++] = a[i++];
        }
        while (j <= high) {
            tmp[k++]=a[j++];
        }
        for (int l = 0; l < a.length; l++) {
            a[l + low] = tmp[l];
        }
    }


    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}


