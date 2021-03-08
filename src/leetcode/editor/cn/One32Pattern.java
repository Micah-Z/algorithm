//给定一个整数序列：a1, a2, ...,
// an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < a
//j。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。 
//
// 注意：n 的值小于15000。 
//
// 示例1: 
//
// 
//输入: [1, 2, 3, 4]
//
//输出: False
//
//解释: 序列中不存在132模式的子序列。
// 
//
// 示例 2: 
//
// 
//输入: [3, 1, 4, 2]
//
//输出: True
//
//解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
// 
//
// 示例 3: 
//
// 
//输入: [-1, 3, 2, 0]
//
//输出: True
//
//解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
// 
// Related Topics 栈 
// 👍 284 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class One32Pattern {
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final Deque<Integer> stack = new LinkedList<>();

        public boolean find132pattern(int[] nums) {
            if (nums.length < 3){
                return false;
            }

            int[] min = new int[nums.length];

            min[0] = nums[0];

            // 先初始化a[i]，保证当有i<j总有a[i]<a[j]
            for (int i = 1; i < nums.length; i++) {
                min[i] = Math.min(min[i - 1],nums[i]);
            }

            // 倒序遍历
            for (int i = nums.length - 1; i > -1; i--) {
                // 这里开始查找第三个数字和第二个数字
                // 保证第三个数字和第二个数字都比第一个数字大
                if (nums[i] > min[i]){
                    // 这里的栈保存第三个数就是a[k]
                    // 出栈是为了保证栈中的元素要比第一个数(a[i])大
                    while (!stack.isEmpty() && stack.peekLast() <= min[i]){
                        stack.pollLast();
                    }

                    // 这里找到最大的那个数a[j]，只需要判断这个数比栈中的顶部那个数大就行
                    // 因为是倒序遍历,所以此时栈中的索引必定比j大，就天然满足k>j，并且a[k] < a[j]
                    if (!stack.isEmpty() && stack.peekLast() < nums[i]){
                        return true;
                    }

                    // 没有特殊操作,直接入栈
                    stack.offerLast(nums[i]);
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}