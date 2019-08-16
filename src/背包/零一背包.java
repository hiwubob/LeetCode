package ����;

public class ��һ���� {
    /**
     * 0-1��������
     * @param V ��������
     * @param N ��Ʒ����
     * @param weight ��Ʒ����
     * @param value ��Ʒ��ֵ
     * @return
     */
    public static String ZeroOnePack(int V,int N,int[] weight,int[] value){
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
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+value[i-1]);
            }
        }
        //������ΪV�ı����ܹ�װ����Ʒ�����ֵΪ
        int maxValue = dp[N][V];
        //�����ҳ�װ�뱳����������Ʒ�ı��
        int j=V;
        String numStr="";
        for(int i=N;i>0;i--){
            //����dp[i][j]>dp[i-1][j],��˵����i����Ʒ�Ƿ��뱳����
            if(dp[i][j]>dp[i-1][j]){
                numStr = i+" "+numStr;
                j=j-weight[i-1];
            }
            if(j==0)
                break;
        }
        return numStr;
    }

    public static void main(String[] args) {
        int[] wei = {5, 3, 2, 10, 4, 8};
        int val[] = {4, 8, 15, 1, 6, 3};
        ��һ���� s=new ��һ����();
        String ss=s.ZeroOnePack(20, 6, wei, val);
        System.out.println(ss);
    }
}
