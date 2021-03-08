//给定一个用字符串表示的整数的嵌套列表，实现一个解析它的语法分析器。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 提示：你可以假定这些字符串都是格式良好的： 
//
// 
// 字符串非空 
// 字符串不包含空格 
// 字符串只包含数字0-9、[、-、,、] 
// 
//
// 
//
// 示例 1： 
//
// 给定 s = "324",
//
//你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 给定 s = "[123,[456,[789]]]",
//
//返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
// Related Topics 栈 字符串 
// 👍 49 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.NestedInteger;

public class MiniParser {
    public static void main(String[] args) {
        Solution solution = new MiniParser().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * // Constructor initializes an empty nested list.
     * public NestedInteger();
     * <p>
     * // Constructor initializes a single integer.
     * public NestedInteger(int value);
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // Set this NestedInteger to hold a single integer.
     * public void setInteger(int value);
     * <p>
     * // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     * public void add(NestedInteger ni);
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    class Solution {
        private char[] chars;

        private int cur = 0;

        public NestedInteger deserialize(String s) {
            //  int length = s.length();
            this.chars = s.toCharArray();
            if (s.length() == 0) {
                return new NestedInteger();
            }
            if (s.charAt(0) != '[') {
                return new NestedInteger(Integer.valueOf(s));
            }
            return this.init();

        }

        private NestedInteger init() {
            NestedInteger nestedInteger = new NestedInteger();
            boolean isPositive = true;
            int result = 0;
            // 如果使用for循环递归时i的值递归到最后又会回到原来的值，这是错的
            /*for (int i = j; i < this.chars.length; i++) {
                if (this.chars[i] == ',') {
                    continue;
                }
                if (this.chars[i] == '[') {
                    // 开始递归遍历
                    nestedInteger.add(init(i + 1));
                } else if (this.chars[i] == ']') {
                    return nestedInteger;
                } else if (chars[i] == '-') {
                    isPositive = false;
                } else {
                    // 处理所有的数字
                    result = result * 10 + (chars[i] - '0');
                    if (chars[i + 1] == ',' || chars[i + 1] == ']') {
                        if (isPositive) {
                            nestedInteger.setInteger(result);
                        } else {
                            nestedInteger.setInteger(result * -1);
                        }
                        result = 0;
                        isPositive = true;
                    }
                }
            }*/
            while (cur < chars.length){
                cur ++;
                if (this.chars[cur] == ',') {
                    continue;
                }
                if (this.chars[cur] == '[') {
                    // 开始递归遍历
                    nestedInteger.add(init());
                } else if (this.chars[cur] == ']') {
                    return nestedInteger;
                } else if (chars[cur] == '-') {
                    isPositive = false;
                } else {
                    // 处理所有的数字
                    result = result * 10 + (chars[cur] - '0');
                    if (chars[cur + 1] == ',' || chars[cur + 1] == ']') {
                        if (isPositive) {
                            // 需要注意,单个数字 例如 1 也是一个NestedInteger，如果有 []包裹那么必须添加一个对象
                            nestedInteger.add(new NestedInteger(result));
                        } else {
                            nestedInteger.add(new NestedInteger(result * -1));
                        }
                        result = 0;
                        isPositive = true;
                    }
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}