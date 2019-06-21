package JIANZHIOffer;

public class No6xuanzhuanzuixiaoshuzi {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int len=array.length;
        int low=0;
        int high=len-1;
        while (low < high) {
            int mid=low+(high-low)/2;
            if (array[mid] > array[high]) {
                low=mid+1;
            } else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high=mid;
            }
        }
        return array[low];
    }
}
