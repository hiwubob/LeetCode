package ����;

public class ��ȫ����2 {
    public static int completePack2(int V,int N,int[] weight,int[] value){
        /**
         * ��ȫ�����ĵڶ��ֽⷨ
         * ˼·��
         * ֻ��һ��һά�����¼״̬��dp[i]��ʾ����Ϊi�ı�������װ����Ʒ������ֵ
         * ��˳����ʵ��
         */
        //��̬�滮
        int[] dp = new int[V+1];
        for(int i=1;i<N+1;i++){
            //˳��ʵ�֣�������������������01����������
            //0��1�����ǴӴ�С��������ȫ�����Ǵ�С�������
            for(int j=weight[i-1];j<V+1;j++){
                dp[j] = Math.max(dp[j-weight[i-1]]+value[i-1],dp[j]);
            }
        }
        return dp[V];
    }
}
