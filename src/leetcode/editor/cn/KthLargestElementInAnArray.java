//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，
// 而不是第 k 个不同的元素。
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 993 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int lastNum;

        public int findKthLargest(int[] nums, int k) {
            // 构建大顶堆
            int length = nums.length;
            for (int i = (length / 2) - 1; i >= 0; i--) {
                this.sink(nums, i, length);
            }
            while (k > 0) {
                lastNum = nums[0];
                k--;
                this.swap(nums, length - 1, 0);
                length--;
                this.sink(nums, 0, length);
            }
            return lastNum;
        }

        /**
         * 下沉数据,让最大的那个数据上浮到第一个位置来
         *
         * @param nums
         * @param index
         * @param length
         */
        private void sink(int[] nums, int index, int length) {
            while ((2 * index) < length - 1) {
                int j = 2 * index + 1;
                if (j < length - 1 && nums[j] < nums[j + 1]) {
                    j++;
                }
                if (nums[j] < nums[index]) {
                    break;
                }
                // 交换数据
                this.swap(nums, j, index);
                index = j;
            }
        }

        private void swap(int[] nums, int j, int index) {
            if (nums[j] != nums[index]) {
                nums[index] ^= nums[j];
                nums[j] ^= nums[index];
                nums[index] ^= nums[j];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}