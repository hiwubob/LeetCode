package JIANZHIOffer;

public class No1ErWeiShuZuDeChaZhao {
    public boolean Find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int m=array[0].length-1;
        int n=0;
        int tmp = array[n][m];
        while (target != tmp) {
            if (m > 0 && n < array.length - 1) {
                if (target > tmp) {
                    n = n + 1;
                } else if (target < tmp) {
                    m = m - 1;
                }
                tmp = array[n][m];
            } else {
                return false;
            }
        }
        return true;
    }
}
