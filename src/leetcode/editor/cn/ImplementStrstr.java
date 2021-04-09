//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 743 👎 0


package leetcode.editor.cn;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) {
                return 0;
            }
            int[] nextVal = this.getNextVal(needle);
            int index = this.select(haystack,needle,nextVal);
            return index;
        }

        private int select(String original, String pattern, int[] nextVal) {
            int length = original.length();
            int pLength = pattern.length();
            if (length < pLength){
                return -1;
            }
            int op = 0;
            int p = 0;
            while (op < length && p < pLength) {
                if (original.charAt(op) == pattern.charAt(p)){
                    op++;
                    p++;
                    if (p == pLength){
                        return op - pLength;
                    }
                }else if (p == 0){
                    op++;
                }else if (original.charAt(op) != pattern.charAt(p)){
                    p = nextVal[p-1];
                }
            }
            return -1;
        }

        /**
         * 创建next数组
         * @param pattern
         * @return
         */
        private int[] getNextVal(String pattern) {
            int i = 0;
            int[] nextVal = new int[pattern.length()];
            nextVal[0] = 0;
            for (int j = 1; j < pattern.length(); j++) {
                int k = j;
                while (k > 0 && pattern.charAt(i) != pattern.charAt(j)){
                    // 如果不相等则进行回溯,一直到-1或者两个字符相等
                    i = nextVal[k - 1];
                    k = i;
                }
                // 不相等才减一,i的初始值为-1,下面有一个加一的操作
                if (pattern.charAt(i) != pattern.charAt(j)){
                    i--;
                }
                i++;
                nextVal[j] = i;
            }
            return nextVal;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {
        public int strStr(String haystack, String needle) {

            if ("".equals(needle)) {
                return 0;
            }

            int first = 0;
            while (first < haystack.length() - needle.length() + 1) {
                if (haystack.charAt(first) == needle.charAt(0)){
                    String substring = haystack.substring(first, first + needle.length());
                    if (substring.equals(needle)){
                        return first;
                    }
                }
                first++;
            }
            return -1;
        }
    }

}