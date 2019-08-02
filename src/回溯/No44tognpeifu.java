package ����;

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
//                ���s1�ĵ� i ���ַ���s2�ĵ� j ���ַ���ͬ������s2�ĵ� j ���ַ�Ϊ ��.��
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
/*    f[i][j]��ʾs1��ǰi���ַ�����s2��ǰj���ַ����ܷ�ƥ��
������ת�Ʒ���

    ���s1�ĵ� i ���ַ���s2�ĵ� j ���ַ���ͬ������s2�ĵ� j ���ַ�Ϊ ��.��
    f[i][j] = f[i - 1][j - 1]
    ���s2�ĵ� j ���ַ�Ϊ *
    ��s2�ĵ� j ���ַ�ƥ��մ�, f[i][j] = f[i][j - 1]
    ��s2�ĵ� j ���ַ�ƥ��s1�ĵ� i ���ַ�, f[i][j] = f[i - 1][j]
    ����ע�ⲻ�� f[i - 1][j - 1]�� �ٸ����Ӿ������� (abc, a*) f[3][2] = f[2][2]
            ��������ʼ��

    f[0][i] = f[0][i - 1] && s2[i] == *
    ��s1��ǰ0���ַ���s2��ǰi���ַ��ܷ�ƥ��*/

}



