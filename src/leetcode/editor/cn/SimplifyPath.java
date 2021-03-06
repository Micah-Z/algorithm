/*
给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格
 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。

 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；
 此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成
部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。

 请注意，返回的 规范路径 必须遵循下述格式：


 始终以斜杠 '/' 开头。
 两个目录名之间必须只有一个斜杠 '/' 。
 最后一个目录名（如果存在）不能 以 '/' 结尾。
 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。


 返回简化后得到的 规范路径 。



 示例 1：


输入：path = "/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。

 示例 2：


输入：path = "/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。


 示例 3：


输入：path = "/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。


 示例 4：


输入：path = "/a/./b/../../c/"
输出："/c"




 提示：


 1 <= path.length <= 3000
 path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 path 是一个有效的 Unix 风格绝对路径。

 Related Topics 栈 字符串
 👍 244 👎 0
*/


package leetcode.editor.cn;

import java.util.*;

public class SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new SimplifyPath().new Solution();
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            // Queue<StringBuilder> stack = new LinkedList<>();
            Stack<String> stack = new Stack<>();
            List<String> pathList = new ArrayList<>();
            // 将路径以 / 分割开，使pathList中不含有 / ,之后再加上 /
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) != '/') {
                    int j = i;
                    while (j < path.length() && path.charAt(j) != '/') {
                        j ++;
                    }
                    pathList.add(path.substring(i,j));
                    i = j;
                }
            }
            for (String s : pathList) {
                // 当前路径不是 . 或者 .. 则直接入栈
                if (!(".".equals(s) || "..".equals(s))){
                    stack.push(s);
                }
                // 遇到 .. 则要出栈,对于.则不用理会
                if ("..".equals(s) && !stack.isEmpty()){
                    stack.pop();
                }
            }
            if (!stack.isEmpty()){
                // 这里可以使用双端队列来做，就不用转为数组获取栈底的数据了
                String[] strings = stack.toArray(new String[0]);
                StringBuilder sb = new StringBuilder();
                sb.append("/");
                for (int i = 0; i < strings.length; i++) {
                    sb.append(strings[i]);
                    if (i != strings.length - 1){
                        sb.append("/");
                    }
                }
                return sb.toString();
            }else {
                return "/";
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}