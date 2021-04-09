//给定一个包含了一些 0 和 1 的非空二维数组 grid 。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，
// 这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。) 
//
// 
//
// 示例 1: 
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
// 
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// [[0,0,0,0,0,0,0,0]] 
//
// 对于上面这个给定的矩阵, 返回 0。 
//
// 
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。 
// Related Topics 深度优先搜索 数组 
// 👍 466 👎 0


package leetcode.editor.cn;

public class MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new MaxAreaOfIsland().new Solution();
        // int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int[][] grid = {{1}};
        solution.maxAreaOfIsland(grid);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int res = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int count = 0;
                    if (grid[i][j] != 0){
                        count = this.getResult(grid,i,j,0);
                    }
                    res = Math.max(res,count);
                }
            }
            return res;
        }

        private int getResult(int[][] grid, int i, int j, int count) {
            if (i >= grid.length || i < 0){
                return count;
            }else if (j >= grid[0].length || j < 0){
                return count;
            }else if (grid[i][j] == 0){
                return count;
            }else {
                grid[i][j] = 0;
                count++;
            }
            int count1 = this.getResult(grid,i,j+1,count);
            int count2 = this.getResult(grid,i,j-1,count1);
            int count3 =  this.getResult(grid,i+1,j,count2);
            return this.getResult(grid,i-1,j,count3);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        public int maxAreaOfIsland(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] dp = new int[height + 1][width + 1];
            int res = 0;
            for (int i = 0; i < height; i++) {
                int m = i + 1;
                for (int j = 0; j < width; j++) {
                    int k = j + 1;
                    if (grid[i][j] != 0) {
                        dp[m][k] = grid[i][j] + dp[m - 1][k] + dp[m][k - 1];
                        dp[m-1][k] = 0;
                        dp[m][k-1] = 0;
                    }
                    res = Math.max(res , dp[m][k]);
                }
            }
            return res;
        }
    }




}