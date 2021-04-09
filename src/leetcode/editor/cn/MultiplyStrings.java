//给定两个以字符串形式表示的非负整数 num1 和 num2，
// 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 595 👎 0


package leetcode.editor.cn;


public class MultiplyStrings {
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        solution.multiply("1234", "567");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            // 做乘法,根据数学推论可以得知两个数相乘最大的位数为两个数的位数之和,
            // 最小的位数为两个数位数之和-1
            // 两个数的积保存在对应下标加1有进位则把进位放在对应下标之和里
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int m = num1.length();
            int n = num2.length();
            int[] res = new int[m + n];
            for (int i = m - 1; i > -1; i--) {
                int n1 = num1.charAt(i) - '0';
                for (int j = n - 1; j > -1; j--) {
                    int n2 = num2.charAt(j) - '0';
                    int r = n1 * n2 + res[i + j + 1];
                    res[i + j + 1] = r % 10;
                    res[i + j] += r / 10;
                    // res[i + j + 1] = n1 * n2 + res[i + j + 1];

                }
            }
            // 将res进行统一的处理,大于10就进位
           /* for (int i = m + n -1; i > 0; i--) {
                // 先处理当前索引-1的数字,这里处理方法很巧妙,先处理前一位可以少用一个缓存变量来存储当前位的数值
                res[i - 1] += res[i] / 10;
                // 再处理当前位置的数字
                res[i] = res[i] % 10;
            }*/
            StringBuilder sb = new StringBuilder();
            for (int i = res[0] == 0 ? 1 : 0; i < m + n; i++) {
                sb.append(res[i]);
            }
            return sb.toString();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        public String multiply(String num1, String num2) {

            // 做加法
            if ("0".equals(num1) || "0".equals(num2)) {
                return "0";
            }
            int m = num1.length();
            String res = "0";
            // 将num1中的每位于num2相乘,然后返回相乘的结果
            for (int i = m - 1; i >= 0; i--) {
                StringBuilder sb = new StringBuilder();
                int k = i;
                while (k < m - 1) {
                    // num1中的位数进一,后面补0
                    sb.append(0);
                    k++;
                }
                String r1 = this.getRes(num1.charAt(i), num2, sb);
                res = this.add(res, r1);
            }
            return res;
        }

        /**
         * 将字符结果进行做加法运算
         *
         * @param res
         * @param r1
         * @return
         */
        private String add(String res, String r1) {
            // 两个字符串做加法
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int i = r1.length() - 1;
            int j = res.length() - 1;
            while (i > -1 || j > -1) {
                int num1 = i > -1 ? r1.charAt(i) - '0' : 0;
                int num2 = j > -1 ? res.charAt(j) - '0' : 0;
                int num = num1 + num2 + carry;
                carry = num / 10;
                sb.append(num % 10);
                i--;
                j--;
            }
            // 最后可能有进位
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }


        /**
         * 将每一个字符与num2整个字符做乘法运算
         *
         * @param c
         * @param num2
         * @param sb
         * @return
         */
        private String getRes(char c, String num2, StringBuilder sb) {
            int num = c - '0';
            int carry = 0;
            for (int i = num2.length() - 1; i > -1; i--) {
                int res = num * (num2.charAt(i) - '0') + carry;
                sb.append(res % 10);
                carry = res / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            return sb.reverse().toString();
        }

    }

}