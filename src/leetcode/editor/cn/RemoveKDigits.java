//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 518 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {
            int length = num.length();

            if (length <= k) {
                return "0";
            }


            Deque<Character> stack = new LinkedList<>();

            for (int i = 0; i < length; i++) {
                char c = num.charAt(i);
                while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
                    stack.pollLast();
                    k--;
                }
                stack.offerLast(c);
            }

            // 去掉末尾的元素，凑足去掉k个字符
            for (int i = 0; i < k; i++) {
                stack.pollLast();
            }

            // 解决头部是0的问题
            StringBuilder sb = new StringBuilder();

            boolean firstIsZero = true;

            for (Character character : stack) {
                if (character == '0' && firstIsZero) {
                    continue;
                }
                firstIsZero = false;
                sb.append(character);
            }

            return sb.toString().length() == 0 ? "0" : sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}