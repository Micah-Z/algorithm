//给你一个字符串 s ，请你去除字符串中重复的字母，
// 使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 由小写英文字母组成 
// 
// Related Topics 栈 贪心算法 字符串 
// 👍 460 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();

        solution.removeDuplicateLetters("abcdefg");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicateLetters(String s) {
            Deque<Character> stack = new LinkedList<>();
            // 字符串最后出现的位置
            int[] charLastIndex = new int[26];
            // 某个字母是否在栈中已经出现
            boolean[] isVisited = new boolean[26];

            char[] charArray = s.toCharArray();

            // 遍历获取字母最后出现的位置
            for (int i = 0; i < charArray.length; i++) {
                charLastIndex[charArray[i] - 'a'] = i;
            }

            // 对字母进行入栈操作

            for (int i = 0; i < charArray.length; i++) {
                // 如果栈中已经存在则直接进入下次循环,遗弃当前的字母
                if (isVisited[charArray[i] - 'a']) {
                    continue;
                }

                // 循环遍历获取最佳的顺序
                while (!stack.isEmpty() &&
                        // 当前的字符串小于栈顶的字符串
                        stack.peekLast() > charArray[i] &&
                        // 并且栈顶的元素在后面为遍历到的元素中还存在
                        charLastIndex[stack.peekLast() - 'a'] > i
                ) {
                    // 移除掉栈顶的元素
                    Character removeLast = stack.removeLast();
                    // 更新isVisited的状态表示当前被移除的元素不在栈里
                    isVisited[removeLast - 'a'] = false;

                }
                // 找到最优的位置之后,将当前遍历的元素入栈
                // 注意入栈调用的是addLast方法,之后取出元素可以直接从第一个开始取出,不用反转列表
                stack.addLast(charArray[i]);
                // 更新一下isVisited的状态,表示当前的元素已经在栈中存在
                isVisited[charArray[i] - 'a'] = true;
            }


            StringBuilder sb = new StringBuilder();
            // 入栈和出栈都是调用的...Last方法,所以不用反转列表
            for (Character character : stack) {
                sb.append(character);
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}