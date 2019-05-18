package LeetCode;

public class T63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp=new int[100][100];
		int r=obstacleGrid.length;
		int c=obstacleGrid[0].length;
		
		for(int i=0;i<r;i++) {
			if(obstacleGrid[i][0]==0)
				dp[i][0]=1;
			else
				break;
		}
		
		for(int i=0;i<c;i++) {
			if(obstacleGrid[0][i]==0)
				dp[0][i]=1;
			else
				break;
		}

		for(int i=1;i<r;i++) {
			for(int j=1;j<c;j++) {
				if(obstacleGrid[i][j]==0)
					dp[i][j]=dp[i-1][j]+dp[i][j-1];
				else
					dp[i][j]=0;
			}
		}
		
		return dp[r-1][c-1];
	}
}
