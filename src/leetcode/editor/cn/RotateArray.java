//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 
//
// 
//
// 进阶： 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？ 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// 
// Related Topics 数组 
// 👍 917 👎 0


package leetcode.editor.cn;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[] nums, int k) {
            // 方法二:
            // 1.先反转整个数组
            // 反转0~k-1的数组
            // 反转 k~ length-1的数组
           /* if (k > nums.length) {
                return;
            }*/
            // 防止k比length大,如果大于length则反转整个数组
            k = k % nums.length;
            // 执行第一步
            this.resver(nums, 0, nums.length-1);
            // 执行第二步
            this.resver(nums, 0, k - 1);
            // 执行第三步
            this.resver(nums, k, nums.length - 1);
        }

        private void resver(int[] nums, int start, int end) {
            while (start < end) {
                if (nums[start] != nums[end]) {
                    nums[start] ^= nums[end];
                    nums[end] ^= nums[start];
                    nums[start] ^= nums[end];
                }
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        // 方法一
        public void rotate(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                int last = nums[nums.length - 1];
                int index = nums.length - 1;
                while (index > 0) {
                    nums[index] = nums[index - 1];
                    index--;
                }
                nums[0] = last;
            }
        }
    }

}