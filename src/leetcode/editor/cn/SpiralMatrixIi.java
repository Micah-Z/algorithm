//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
// 且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 390 👎 0


package leetcode.editor.cn;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            // 解题方法:一圈一圈赋值,需要注意如果n是极速那么最后一个数字单独赋值就行
            int[][] res = new int[n][n];
            // 指针
            int i = 0;
            // 起始圈数
            int count = 0;
            // 起始值
            int firstNum = 1;
            // 最大值
            int maxNum = n * n;
            while (firstNum <= maxNum) {
                int k, j;
                k = j = i;
                if (i == n - 1){
                    res[i][i] = maxNum;
                    break;
                }
                // 从左到右
                while (j < n ) {
                    res[k][j++] = firstNum;
                    firstNum++;
                }
                // 从上到下
                while (k < n - 1 ) {
                    // 先让k+1是为了去掉右上角
                    res[++k][n-1] = firstNum;
                    firstNum++;
                }
                // 从右到左
                // 重新设置两个辅助指针,因为此时已经有三个角的值已经确定下来了,必须去除这个角
                int p = n-1;
                j = j - 1;
                while (j > count) {
                    res[p][--j] = firstNum;
                    firstNum++;
                }
                // 从下到上
                p = p -1;
                while (p > count) {
                    res[p--][count] = firstNum;
                    firstNum++;
                }
                count++;
                n--;
                i++;
            }

            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}