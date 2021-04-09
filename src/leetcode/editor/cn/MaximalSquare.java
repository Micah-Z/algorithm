//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 动态规划 
// 👍 729 👎 0


package leetcode.editor.cn;

public class MaximalSquare {
    public static void main(String[] args) {
        Solution solution = new MaximalSquare().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximalSquare(char[][] matrix) {
            // 转移方程 dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1]) + 1
            // 这里的dp[i][j]表示如果matrix[i][j] != 0 的话,他就是以i,j为右下角的正方形的最大边长
            int height = matrix.length;
            int width = matrix[0].length;
            int[][] dp = new int[height + 1][width + 1];
            int max = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] != '0'){
                        dp[i + 1][j + 1] = Math.min(dp[i][j],Math.min(dp[i + 1][j],dp[i][j + 1])) + 1;
                        max = Math.max(max,dp[i + 1][j + 1]);
                    }
                }
            }
            return max * max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}