//给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2525 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class ReverseInteger {
    public static void main(String[] args) {
        // Solution solution = new ReverseInteger().new Solution();
        System.out.println(String.valueOf(1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            /*if (x > -10 && x < 10) {
                return x;
            }
            String str = String.valueOf(x);
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            if (chars[0] == '-') {
                for (int i = chars.length - 1; i > 0; i--) {
                    if (chars[i] != '0' || sb.length() > 0) {
                        sb.append(chars[i]);
                    }
                }
                sb.insert(0, '-');
            } else {
                for (int i = chars.length - 1; i >= 0; i--) {
                    if (chars[i] != '0' || sb.length() > 0) {
                        sb.append(chars[i]);
                    }
                }
            }
            double parseDouble = Double.parseDouble(sb.toString());
            if (parseDouble > Integer.MAX_VALUE || parseDouble < Integer.MIN_VALUE){
                return 0;
            }
            return Integer.parseInt(sb.toString());*/

            int res = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                if (res > (Integer.MAX_VALUE / 10) || ((res == Integer.MAX_VALUE) && pop > 7)) {
                    return 0;
                }
                if (res < (Integer.MIN_VALUE / 10) || ((res == Integer.MIN_VALUE) && pop < -8)) {
                    return 0;
                }
                res = res * 10 + pop;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}