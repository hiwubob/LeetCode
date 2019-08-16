package JIANZHIOffer;

public class No35shuzuzhongdenixushu {
        int count;

    public int InversePairs(int[] array) {
        count=0;
        if (array != null) {
            mergeSortUp2Down(array, 0, array.length - 1);
        }
        return count;
    }

    private void mergeSortUp2Down(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid=(start+end)/2;
        mergeSortUp2Down(array, start,mid);
        mergeSortUp2Down(array,mid+1,end);
        merge(array,start,mid,end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i=start;
        int j=mid+1;
        int k=0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                count+=mid-1+1;//对于j来说，比它大的有mid-i+1个

            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= end) {
            tmp[k++] = array[j++];
        }
//        用新数组的数覆盖array数组
        for (k = 0; k < tmp.length; k++) {
            array[start+k]=tmp[k];
        }
    }
}
