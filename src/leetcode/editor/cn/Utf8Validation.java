//UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则： 
//
// 
// 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。 
// 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，
// 后面字节的前两位一律设为 10 。剩下的没有提及的二进制位
//，全部为这个符号的 unicode 码。 
// 
//
// 这是 UTF-8 编码的工作方式： 
//
// 
//   Char. number range  |        UTF-8 octet sequence
//      (hexadecimal)    |              (binary)
//   --------------------+---------------------------------------------
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// 
//
// 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。 
//
// 注意： 
//输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。 
//
// 示例 1： 
//
// 
//data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.
//
//返回 true 。
//这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
// 
//
// 示例 2： 
//
// 
//data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.
//
//返回 false 。
//前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
//下一个字节是开头为 10 的延续字节，这是正确的。
//但第二个延续字节不以 10 开头，所以是不符合规则的。
// 
// Related Topics 位运算 
// 👍 64 👎 0


package leetcode.editor.cn;

public class Utf8Validation {
    public static void main(String[] args) {
        Solution solution = new Utf8Validation().new Solution();
        int[] nums = {235, 140, 4};
        solution.validUtf8(nums);
        System.out.println(Integer.toBinaryString(235));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validUtf8(int[] data) {
            int index = 0;
            int effectiveCount = 0;
            while (index < data.length) {
                int origin = data[index];
                if (effectiveCount == 0) {
                    // 计算起始有效位数
                    effectiveCount = getEffectiveCount(origin);
                    if (effectiveCount == 0) {
                        index++;
                        continue;
                    }
                    if (effectiveCount > 4 || effectiveCount == 1) {
                        return false;
                    }
                    effectiveCount--;
                } else {
                    // 如果他是第一位之后的续位,那么第一位必须为1第二位必须为0
                    if ((data[index] & (1 << 7)) == 0 ||  (data[index] & (1 << 6)) != 0) {
                        return false;
                    }
                    effectiveCount--;
                }
                index++;
            }
            return effectiveCount == 0;
        }

        private int getEffectiveCount(int origin) {
            int bitCount = 7;
            int effectiveCount = 0;
            while (bitCount >= 0) {
                if ((origin & (1 << bitCount)) != 0) {
                    effectiveCount++;
                } else {
                    break;
                }
                bitCount--;
            }
            return effectiveCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}