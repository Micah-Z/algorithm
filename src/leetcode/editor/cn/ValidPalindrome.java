//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 348 👎 0


package leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("race a car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if ("".equals(s)){
                return true;
            }
            int first = 0;
            int last = s.length() - 1;

            while (first < last){
                if (!Character.isLetter(s.charAt(first)) && !Character.isDigit(s.charAt(first))){
                    first++;
                    continue;
                }
                if (!Character.isLetter(s.charAt(last)) &&  !Character.isDigit(s.charAt(last))){
                    last--;
                    continue;
                }
                if (Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last))){
                    return false;
                }
                first++;
                last--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}