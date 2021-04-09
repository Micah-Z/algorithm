//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5196 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 使用数组模拟窗口,所有的字符加起来也不会超过128个的,实例化一个数组,容量为128就行
            // 数组的内容是记录字符在字符串中的索引的位置
            int[] chars = new int[128];
            for (int i = 0; i < 128; i++) {
                chars[i] = -1;
            }
            // 窗口的左边
            int start = 0;
            int res = 0;
            // i相当于窗口的右边
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i);
                // 如果有重复的字符,移动窗口,直到窗口中没有重复的字符,窗口滑动的核心
                start = Math.max(start, chars[index] + 1);
                res = Math.max(res, i - start + 1);
                chars[index] = i;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int length = s.length();
            /*if (length == 0){
                return 0;
            }
            if (length == 1){
                return 1;
            }*/
            int fast = -1;
            int max = 0;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    // 缩小窗口
                    set.remove(s.charAt(i - 1));
                }
                while (fast + 1 < length && !set.contains(s.charAt(fast + 1))) {
                    // 不断移动右指针,增大窗口
                    set.add(s.charAt(++fast));
                }
                max = Math.max(max, set.size());
            }
            return max;
        }
    }


    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            int length = s.length();
            /*if (length == 0){
                return 0;
            }
            if (length == 1){
                return 1;
            }*/
            int slow = 0;
            int max = 0;
            while (slow < length) {
                Set<Character> set = new HashSet<>();
                int fast = slow;
                while (fast < length) {
                    if (!set.add(s.charAt(fast))) {
                        // max = Math.max(max,set.size());
                        break;
                    }
                    max = Math.max(max, set.size());
                    fast++;
                }
                slow++;
            }
            return max;
        }
    }

}