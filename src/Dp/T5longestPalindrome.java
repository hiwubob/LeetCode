package Dp;

public class T5longestPalindrome {
    /*    dp[i][j] ：表示是arr[i..j]范围内的字符是否是回文
        解释下动态转移方程： dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
        上面的动态转移方程大致有两种情况：(在char[i] == char[j]的情况下，如果相等，arr[i..j] 这个区间肯定不是回文子串)
                1. 当j - i <= 2 说明 arr[i..j] 长度至多为3，
        长度为1没有什么可讲的，如a 自己和自己相等，j - i = 0 <= 2，满足条件
        长度为2时，也是回文 如 bb
        长度为3时，其实是奇回文，如aba
    2.dp[i + 1][j - 1] 这个值其实是dp格子中的左下方的位置，如上述的(0,4) 所要依赖是（1,3）
                (0,4)-->ababa 0 位置是一个1 4 位置是最后一个a  （1,3） --> ababa 标红的部分，其实说白了就是当前的字符的首尾是相等的，需要去头去尾的字符串是否是回文*/
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int len = s.length();
        String res = null;
        int max = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}
