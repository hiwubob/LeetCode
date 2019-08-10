package 回溯;

public class No44tognpeifu {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                如果s1的第 i 个字符和s2的第 j 个字符相同，或者s2的第 j 个字符为 “.”
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    f[i][j] = f[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }
/*    f[i][j]表示s1的前i个字符，和s2的前j个字符，能否匹配
（二）转移方程

    如果s1的第 i 个字符和s2的第 j 个字符相同，或者s2的第 j 个字符为 “.”
    f[i][j] = f[i - 1][j - 1]
    如果s2的第 j 个字符为 *
    若s2的第 j 个字符匹配空串, f[i][j] = f[i][j - 1]
    若s2的第 j 个字符匹配s1的第 i 个字符, f[i][j] = f[i - 1][j]
    这里注意不是 f[i - 1][j - 1]， 举个例子就明白了 (abc, a*) f[3][2] = f[2][2]
            （三）初始化

    f[0][i] = f[0][i - 1] && s2[i] == *
    即s1的前0个字符和s2的前i个字符能否匹配*/

}



