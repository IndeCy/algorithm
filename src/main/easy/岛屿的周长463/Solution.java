package easy.岛屿的周长463;

public class Solution {

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0){
                    res+=checkLength(grid,i,j);
                }
            }
        }
        return res;
    }

    /**
     * 判断该处陆地能为岛屿周长贡献几条边
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int checkLength(int[][] grid,int i,int j){
        int res = 4;
        //上边
        if(i!=0 && grid[i-1][j] != 0){
            res--;
        }
        //左边
        if(j!=0 && grid[i][j-1] != 0){
            res--;
        }
        //右边
        if(j+1 < grid[i].length && grid[i][j+1] != 0){
            res--;
        }
        //下边
        if(i+1< grid.length && grid[i+1][j] != 0){
            res--;
        }
        return res;
    }
}
