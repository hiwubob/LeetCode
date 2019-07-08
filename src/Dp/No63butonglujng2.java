package Dp;

public class No63butonglujng2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int[][] dp = new int[100][100];
        int r=obstacleGrid.length;
        int c=obstacleGrid[0].length;

        for(int i=0;i<r;++i){  //第一列
            if(0==obstacleGrid[i][0])  //因为只能向下或者向右走，所以从起点来到该点方法有一种
                dp[i][0]=1;
            else
                break;         //阻塞了，接下来不用考虑下面的点，肯定走不到
        }
        for(int i=0;i<c;++i){ //第一行 同理
            if(0==obstacleGrid[0][i])
                dp[0][i]=1;
            else
                break;
        }
        for(int i=1;i<r;++i)
            for(int j=1;j<c;++j){
                if(0==obstacleGrid[i][j])
                    dp[i][j]=dp[i-1][j]+dp[i][j-1]; //从起点走到该点有几种途径等于
                    //从起点到该点上面的点和该点左
                    //边的点途径之和
                else
                    dp[i][j]=0;
            }
        return dp[r-1][c-1];

    }
}
