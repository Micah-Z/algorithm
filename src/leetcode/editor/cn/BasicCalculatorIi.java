//实现一个基本的计算器来计算一个简单的字符串表达式的值。 
//
// 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格 。 整数除法仅保留整数部分。 
//
// 示例 1: 
//
// 输入: "3+2*2"
//输出: 7
// 
//
// 示例 2: 
//
// 输入: " 3/2 "
//输出: 1 
//
// 示例 3: 
//
// 输入: " 3+5 / 2 "
//输出: 5
// 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 字符串 
// 👍 255 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BasicCalculatorIi {
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        solution.calculate("56+36+4+15*12");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Deque<Integer> stack = new LinkedList<>();
        public int calculate(String s) {

            return getResult(s,0);
        }

        private int getResult(String s,int j) {
            int num = 0;
            char sign = '+';

            char[] chars = s.toCharArray();
            for (int i = j; i < chars.length; i++) {
                if (chars[i] == '('){
                    getResult(s,i);
                    // 递归遍历结束之后此时i的指向为 ),所以要加1
                    i ++;
                }
                if (Character.isDigit(chars[i])){
                    num = num * 10 + (chars[i] - '0');
                }
                if ((!Character.isDigit(chars[i]) && chars[i] != ' ') || i == chars.length - 1 ){
                    // 当前的字符不是数字,或者到了最后一个数字,则放入栈中
                    switch (sign){
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            // 如果是乘法运算,则直接先运算后入栈
                            stack.push(stack.pop() * num);
                            break;
                        case '/':
                            stack.push(stack.pop() / num);
                            break;
                        default:
                    }
                    sign = chars[i];
                    num = 0;
                }
                if (chars[i] == ')'){
                    break;
                }
            }

            // 将栈中的值都相加
            int res = 0;
            while (!stack.isEmpty()){
                res = res + stack.pop();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}