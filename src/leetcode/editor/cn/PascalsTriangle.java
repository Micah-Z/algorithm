//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 463 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        solution.generate(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            int[][] nums = new int[numRows][numRows];
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> numList = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i){
                        nums[i][j] = 1;
                    }else {
                        nums[i][j] = nums[i - 1][j-1] + nums[i-1][j];
                    }
                    numList.add(nums[i][j]);
                }
                list.add(numList);
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}