package LeetCode;

public class T980 {
	//不同路径
	/*在二维网格 grid 上，有 4 种类型的方格：

1 表示起始方格。且只有一个起始方格。
2 表示结束方格，且只有一个结束方格。
0 表示我们可以走过的空方格。
-1 表示我们无法跨越的障碍。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次*/
	    int row;
	    int col;
	    int count=0;
	    public int uniquePathsIII(int[][] grid) {
	        row=grid.length;
	        col=grid[0].length;
	        int[][] visited=new int[row][col];
	        int startx=0,starty=0,endx=0,endy=0;
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                if(grid[i][j]==1){
	                    startx=i;
	                    starty=j;
	                }
	                if(grid[i][j]==2){
	                    endx=i;
	                    endy=j;
	                }
	            }
	        }
	        dfs(startx,starty,endx,endy,grid,visited);
	        return count;
	    }
		private void dfs(int x, int y, int endx, int endy, int[][] grid, int[][] visited) {
			if(x<0 || x>=row || y<0 || y>=col || visited[x][y]!=0 || grid[x][y]==-1)
				return;
			if(x==endx &&y==endy && hadDfs(grid,visited)) {
				count++;
				return;
			}
			visited[x][y]=1;
			dfs(x-1,y,endx,endy,grid,visited);			
			dfs(x,y-1,endx,endy,grid,visited);			
			dfs(x+1,y,endx,endy,grid,visited);						
			dfs(x,y+1,endx,endy,grid,visited);		
			visited[x][y]=0;
		}
		private boolean hadDfs(int[][] grid, int[][] visited) {
			int m=grid.length;
			int n=grid[0].length;
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					if(grid[i][j]==0 && visited[i][j]==0)
						return false;
				}
			}
			return true;
		}
	    
	
}
