package beibao;

public class ��һ�����Ż� {
    /**
     * 0-1�������Ż��ⷨ
     * ˼·��
     * ֻ��һ��һά�����¼״̬��dp[i]��ʾ����Ϊi�ı�������װ����Ʒ������ֵ
     * ��������ʵ��
     */
    public static int ZeroOnePack2(int V,int N,int[] weight,int[] value){
        //��̬�滮
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //����ʵ��
            //v��������
            for(int j=V;j>=weight[i-1];j--){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }
}
