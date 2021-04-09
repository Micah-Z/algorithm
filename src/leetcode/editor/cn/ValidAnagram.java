//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 356 👎 0


package leetcode.editor.cn;

public class ValidAnagram {
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] charCount1 = new int[26];

            int[] charCount2 = new int[26];

            for (char c : s.toCharArray()) {
                charCount1[c - 'a']++;
            }

            for (char c : t.toCharArray()) {
                charCount2[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (charCount1[i] != charCount2[i]){
                    return false;
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}