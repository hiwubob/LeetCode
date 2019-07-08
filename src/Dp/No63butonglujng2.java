package Dp;

public class No63butonglujng2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int[][] dp = new int[100][100];
        int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;

        for(int i=0;i<r;++i){  //��һ��
            if(0==obstacleGrid[i][0])  //��Ϊֻ�����»��������ߣ����Դ���������õ㷽����һ��
                dp[i][0]=1;
            else
                break;         //�����ˣ����������ÿ�������ĵ㣬�϶��߲���
        }
        for(int i=0;i<c;++i){ //��һ�� ͬ��
            if(0==obstacleGrid[0][i])
                dp[0][i]=1;
            else
                break;
        }
        for(int i=1;i<r;++i)
            for(int j=1;j<c;++j){
                if(0==obstacleGrid[i][j])
                    dp[i][j]=dp[i-1][j]+dp[i][j-1]; //������ߵ��õ��м���;������
                    //����㵽�õ�����ĵ�͸õ���
                    //�ߵĵ�;��֮��
                else
                    dp[i][j]=0;
            }
        return dp[r-1][c-1];

    }
}
