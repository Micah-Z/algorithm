//给定一个正整数 n ，输出外观数列的第 n 项。 
//
// 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。 
//
// 你可以将其视作是由递归公式定义的数字字符串序列： 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。 
// 
//
// 前五项如下： 
//
// 
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1 
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
// 
//
// 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成
//一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。 
//
// 例如，数字字符串 "3322251" 的描述如下图： 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出："1"
//解释：这是一个基本样例。
// 
//
// 示例 2： 
//
// 
//输入：n = 4
//输出："1211"
//解释：
//countAndSay(1) = "1"
//countAndSay(2) = 读 "1" = 一 个 1 = "11"
//countAndSay(3) = 读 "11" = 二 个 1 = "21"
//countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 30 
// 
// Related Topics 字符串 
// 👍 656 👎 0


package leetcode.editor.cn;

public class CountAndSay {
    public static void main(String[] args) {
        Solution solution = new CountAndSay().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String countAndSay(int n) {
            // 递归解决
            if (n == 1){
                return "1";
            }

            // 获取上一个数字对应的字符串
            String lastStr = countAndSay(n - 1);
            // 记录字符串的起始索引
            int start = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lastStr.length(); i++) {
                // 如果字符串出现不相同的字符
                if (lastStr.charAt(i) != lastStr.charAt(start)){
                    sb.append(i - start).append(lastStr.charAt(start));
                    start = i;
                }
            }
            // 处理最后一个字符，无论只有一个或者多个，在这里都可以统一处理
            sb.append(lastStr.length() - start).append(lastStr.charAt(start));

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        public String countAndSay(int n) {
            // 循环解决
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            // 已经有1，循环n-1次
            for (int i = 1; i < n; i++) {
                StringBuilder s = new StringBuilder();
                // 记录每个数字开始的索引
                int start = 0;
                for (int j = 1; j < sb.length(); j++) {
                    if (sb.charAt(j) != sb.charAt(start)){
                        // 数字发生了变化
                        s.append(j - start).append(sb.charAt(start));
                        // 更新start的位置
                        start = j;
                    }
                }
                // 数字如果一直没有变化，直接处理最8后一个数字
                s.append(sb.length() - start).append(sb.charAt(start));
                // sb重新赋值
                sb = s;
            }

            return sb.toString();
        }
    }

}