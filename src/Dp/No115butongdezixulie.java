package Dp;

public class No115butongdezixulie {
//    https://blog.pwrliang.com/2019/02/25/115-%E4%B8%8D%E5%90%8C%E7%9A%84%E5%AD%90%E5%BA%8F%E5%88%97/
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        int m = s.length() + 1;
        int n=t.length()+1;
        int[][] dp=new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0]=1;//dp[0][j]与dp[i][0]表示空串
        }
        for (int j = 1; j < n; j++) {
            dp[0][j]=0;//dp[0][j]与dp[i][0]表示空串
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j];//如果S[i] ≠ T[j]，则dp[i][j] = dp[i-1][j]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j]+=dp[i-1][j-1];//当S[i] = T[j]时，dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
