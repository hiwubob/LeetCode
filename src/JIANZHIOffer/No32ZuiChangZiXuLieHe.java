package JIANZHIOffer;

public class No32ZuiChangZiXuLieHe {
    public int FindGreatestSumSubArray(int[] array) {
        int res = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
