//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 342 👎 0


package leetcode.editor.cn;

public class AddStrings {
    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            while (i > -1 || j > -1){
                int n1 = i > -1 ? num1.charAt(i) - '0' : 0;
                int n2 = j > -1 ? num2.charAt(j) - '0' : 0;
                int num = n1 + n2 + carry;
                carry = num / 10;
                sb.append(num % 10);
                i--;
                j--;
            }
            if (carry != 0){
                sb.append(carry);
            }
            return sb.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}