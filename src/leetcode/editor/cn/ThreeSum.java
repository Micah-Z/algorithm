//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
// 使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针
// 👍 3029 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = new int[]{-1,0,1,2,-1,4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            // 解题思路:先排序,然后使用三个指针遍历,第一个指针和第二个指针从左往右遍历,第三个指针从右
            // 往左遍历,如果三个数想加大于-num[i](i为第一个指针)第三个指针往左移动(小于的话不用移动,越移动越小了),
            // 如果相等就添加到列表中,如果是其他情况就让第二个指针移动
            // 先排序,按照从小到大排列
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int first = 0; first < nums.length; first++) {
                // 由于已经排序,这里保证不重复遍历
                if (first > 0 && nums[first] == nums[first - 1]){
                    continue;
                }
                int target = -nums[first];
                // 每一次大循环第三个指针都要重新开始往左移动
                int third = nums.length - 1;
                for (int second  = first + 1; second  < nums.length; second++) {
                    // 这里同样要保证相邻的两个数不同
                    if (second > first + 1 && nums[second] == nums[second - 1]){
                        continue;
                    }
                    while (third > second && nums[second] + nums[third] > target){
                        // 第三个指针往左移动
                        third--;
                    }

                    if (third == second){
                        // 第二个与第三个指针重合了,直接退出不会存在nums[a] + num[b] + num[c] = 0
                        break;
                    }
                    if (nums[second] + nums[third] == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        res.add(list);
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}