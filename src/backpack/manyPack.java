package backpack;

public class manyPack {
    /**
     * �����౳�������ر���
     *
     */
    public static int manyPack(int V,int N,int[] weight,int[] value,int[] num){
        //��ʼ����̬�滮����
        int[][] dp = new int[N+1][V+1];
        //Ϊ�˱�������,��dp[i][0]��dp[0][j]����Ϊ0����1��ʼ����
        for(int i=1;i<N+1;i++){
            for(int j=1;j<V+1;j++){
                //�����i����Ʒ���������ڱ�������j,��װ�뱳��
                //����weight��value�����±궼�Ǵ�0��ʼ,��ע���i����Ʒ������Ϊweight[i-1],��ֵΪvalue[i-1]
                if(weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else{
                    //������Ʒ�ļ�������
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for(int k=0;k<maxV+1;k++){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }
        /*//������ΪV�ı����ܹ�װ����Ʒ�����ֵΪ
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
        }*/
        return dp[N][V];
    }

}