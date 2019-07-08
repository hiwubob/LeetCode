package beibao;

public class ��ȫ���� {
    /**
     * �ڶ��౳������ȫ����
     * ˼·������
     * 01������������ǰһ�������⣨i-1����Ʒ���Ļ������������ǰ���⣨i����Ʒ����
     * ��i-1����Ʒʱ�ı�����ӵ�i����Ʒ������ȫ�����������ڽ����ǰ���⣨i����Ʒ��
     * ��i����Ʒʱ�ı�����ӵ�i����Ʒ��
     * �ƹ�ʽ����ʱ��f[i][y] = max{f[i-1][y], (f[i][y-weight[i]]+value[i])}��
     * ע�����ﵱ���Ƿ���һ����Ʒ i ʱӦ�����ǻ����ܼ������� i��
     * ���������f[i][y-weight[i]]+value[i], ������f[i-1][y-weight[i]]+value[i]��
     * @param V
     * @param N
     * @param weight
     * @param value
     * @return
     */
    public static String completePack(int V,int N,int[] weight,int[] value){
        //��ʼ����̬�滮����
        int[][] dp = new int[N+1][V+1];
        //Ϊ�˱������,��dp[i][0]��dp[0][j]����Ϊ0����1��ʼ����
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //�����i����Ʒ���������ڱ�������j,��װ�뱳��
                //����weight��value�����±궼�Ǵ�0��ʼ,��ע���i����Ʒ������Ϊweight[i-1],��ֵΪvalue[i-1]
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i-1]]+value[i-1]);
            }
        }
        //������ΪV�ı����ܹ�װ����Ʒ�����ֵΪ
        int maxValue = dp[N][V];
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //����dp[i][j]>dp[i-1][j],��˵����i����Ʒ�Ƿ��뱳����
            while(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }
        return numStr;
    }
}
