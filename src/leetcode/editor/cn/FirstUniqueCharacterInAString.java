//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 360 👎 0


package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {

            if ("".equals(s)){
                return -1;
            }

            Map<Character,Integer> map = new LinkedHashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c,map.getOrDefault(c,0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1){
                    return s.indexOf(entry.getKey());
                }
            }
           return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}