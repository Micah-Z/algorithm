//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，
// 使 nums1 成为一个有序数组。
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 805 👎 0


package leetcode.editor.cn;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 三个指针解决
            // 两个遍历指针从后面开始遍历,一个指针指向num1的最后一个位置
            int p1 = m - 1;
            int p2 = n - 1;
            int p = m + n - 1;

            while ((p1 >= 0) && (p2 >= 0)) {
                // 这里使用倒插,插入的元素应该是最大的一个
                nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
            }

            // 最后如果num2中还有数据但是num1中的数据已经遍历完了,那么就拷贝过去,这时num2中的数据应该都比num1中的小
            // 所以最后只需要将p2+1个元素插入过去就行
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 双指针解决
            // 两个指针都是从前面开始遍历
            int first, second;
            first = second = 0;
            int[] num = new int[m + n];
            int index = 0;
            while (first < m && second < n && index < m + n) {
                if (nums1[first] < nums2[second]) {
                    num[index++] = nums1[first++];
                    continue;
                }
                if (nums1[first] > nums2[second]) {
                    num[index++] = nums2[second++];
                    continue;
                }
                if (nums1[first] == nums2[second]) {
                    num[index++] = nums1[first++];
                    num[index++] = nums2[second++];
                }
            }
            while (first < m && index < m + n) {
                num[index++] = nums1[first++];
            }

            while (second < n && index < m + n) {
                num[index++] = nums2[second++];
            }
            System.arraycopy(num, 0, nums1, 0, nums1.length);
        }
    }

}