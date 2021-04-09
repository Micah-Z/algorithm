//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 输入的字符串只包含小写字母 
// 两个字符串的长度都在 [1, 10,000] 之间 
// 
// Related Topics 双指针 Sliding Window 
// 👍 327 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        Solution solution = new PermutationInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            if (m > n){
                return false;
            }
            int[] str1 = new int[26];
            int[] str2 = new int[26];
            for (int i = 0; i < m; i++) {
                // 根据s1的大小在s2中生成一个和s1长度一样长的窗口
                str1[s1.charAt(i) - 'a']++;
                str2[s2.charAt(i) - 'a']++;
            }
            if (Arrays.equals(str1,str2)){
                return true;
            }
            // 移动窗口,始终保证窗口的大小为需要匹配字符串的长度
            for (int i = m; i < n; i++) {
                // 右边增大
                str2[s2.charAt(i) - 'a']++;
                // 左边减小
                str1[s2.charAt(i) - 'a']--;
                // 窗口改变之后再进行比较
                if (Arrays.equals(str1,str2)) {
                    return true;
                }
            }
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public boolean checkInclusion(String s1, String s2) {
            int[] orignChars = new int[128];
            for (int i = 0; i < s1.length(); i++) {
                orignChars[s1.charAt(i)] += 1;
            }
            for (int i = 0; i < s2.length(); i++) {
                int[] temp = new int[128];
                System.arraycopy(orignChars,0,temp,0,128);
                int count = 0;
                for (int j = i; j < i + s1.length() && j < s2.length(); j++) {
                    if (temp[s2.charAt(j)] != 0){
                        temp[s2.charAt(j)]--;
                        count++;
                    }else {
                        break;
                    }
                }
                if (count == s1.length()){
                    return true;
                }
            }
            return false;
        }
    }

}