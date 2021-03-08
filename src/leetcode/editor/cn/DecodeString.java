//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 675 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new DecodeString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private StringBuilder sb;

        /*private Deque<String> stringStack = new LinkedList<>();

        private Deque<Integer> numStack = new LinkedList<>();*/
        /*public String decodeString(String s) {

            // 使用辅助栈来解决

            int num = 0;

            sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                if (c == '['){
                    // 遇见[就入栈
                    numStack.offerLast(num);
                    stringStack.offerLast(sb.toString());
                    // 将变量进行初始化，为下一次入栈做准备
                    sb = new StringBuilder();
                    num = 0;
                }else if (c == ']'){
                    // 出栈
                    Integer count = numStack.pollLast();
                    String str = stringStack.pollLast();
                    StringBuilder tem = new StringBuilder();
                    while (count > 0){
                        // 将sb中的字符串重复上次添加到缓存中
                        tem.append(sb);
                        count--;
                    }
                    // 更新sb中的内容,更新后的内容为处理重复后的加上栈中的
                    // 这里还不能弄反了,栈中的元素应该在前面
                    sb = new StringBuilder(str + tem);
                }else if (Character.isDigit(c)){
                    num = num * 10 + c - '0';
                }else {
                    // 最后处理一般的字母了
                    sb.append(c);
                }
            }
            return sb.toString();
        }*/

        // 递归解法
        public String decodeString(String s) {

            return this.getResult(s,0)[0];

        }

        private String[] getResult(String s, int i) {
            StringBuilder sb = new StringBuilder();
            int num = 0;
            while (i < s.length()){
                // 如果是数字
                if (Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                }else if (s.charAt(i) == '['){
                    // 如果是 [ 开始递归
                    String[] result = this.getResult(s, i + 1);
                    // 递归结束后,开始处理字母叠加
                    i = Integer.parseInt(result[0]);
                    while (num > 0){
                        sb.append(result[1]);
                        num--;
                    }
                }else if (s.charAt(i) == ']'){
                    // 递归出口
                    return new String[]{String.valueOf(i),sb.toString()};
                }else {
                    // 处理一般的字母
                    sb.append(s.charAt(i));
                }
                i++;
            }
            // 遍历结束
            return new String[]{sb.toString()};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}