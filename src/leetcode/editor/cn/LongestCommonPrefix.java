//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1510 👎 0


package leetcode.editor.cn;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            // 横向查找

            if (strs.length == 0){
                return "";
            }
            for (int i = 0; i < strs[0].length(); i++) {
                // 以第一个字符串为基准，横向查找其他的字符串进行匹配，看每一位是否相同
                // 如果不相同就直接返回从0到i-1个字符
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c){
                        return strs[0].substring(0,i);
                    }
                }
            }
            return strs[0];
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0){
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs[0].length(); i++) {
                sb.append(strs[0].charAt(i));
                for (int j = 1; j < strs.length; j++) {
                    if (!strs[j].startsWith(sb.toString())){
                        sb.deleteCharAt(i);
                        return sb.toString();
                    }
                }
            }
            return sb.toString();
        }
    }


    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0){
                return "";
            }
            // 纵向查找
            String prefix = strs[0];
            for (int i = 1; i < strs.length; i++) {
                prefix = this.getMaxPrefix(prefix,strs[i]);
                if ("".equals(prefix)){
                    return "";
                }
            }
            return prefix;
        }

        /**
         * 遍历数组中的每一个字符串，判断是否与prefix有公共的前缀，如果有则返回公共前缀
         * 通过不断减少公共前缀来减少时间复杂度
         * @param prefix
         * @param str
         * @return
         */
        private String getMaxPrefix(String prefix, String str) {
            int index = 0;
            int maxLength = Math.min(prefix.length(),str.length());
            while (index < maxLength && prefix.charAt(index) == str.charAt(index)){
                index++;
            }
            return prefix.substring(0,index);
        }
    }

}