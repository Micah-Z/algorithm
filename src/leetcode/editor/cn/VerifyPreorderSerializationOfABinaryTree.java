//序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，
// 我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
//
//      _9_
//    /   \
//   3     2
//  / \   / \
// 4   1  #  6
/// \ / \   / \
//# # # #   # #
// 
//
// 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。 
//
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。 
//
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。 
//
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。 
//
// 示例 1: 
//
// 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
//输出: true 
//
// 示例 2: 
//
// 输入: "1,#"
//输出: false
// 
//
// 示例 3: 
//
// 输入: "9,#,#,1"
//输出: false 
// Related Topics 栈 
// 👍 154 👎 0


package leetcode.editor.cn;

public class VerifyPreorderSerializationOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new VerifyPreorderSerializationOfABinaryTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValidSerialization(String preorder) {
            int slots = 1;

            int length = preorder.length();

            for (int i = 0; i < length; i++) {
                if (preorder.charAt(i) == ','){
                    // 消耗掉了一个位置
                    slots--;
                    // 这个if判断必须在下面那个之前，只有消耗完一个槽位，才判断是否过渡消耗了槽位，
                    // 下面这个增加了槽位就会影响判断
                    if (slots < 0){
                        // 槽位为负数，直接返回false
                        return false;
                    }
                    if (preorder.charAt(i - 1) != '#'){
                        // 不是空节点，增加两个槽位
                        slots = slots + 2;
                    }
                }
            }
            // 处理最后一个字符，因为最后一个字符后面没有逗号
            // 如果最后一个字符是#表示只会消耗一个槽位，
            // 如果不是则会消耗一个增加两个，最后增加一个槽位
            slots = (preorder.charAt(length - 1) == '#') ? slots -1 : slots + 1;

            // 正常情况下所有的槽位应该正好消耗完毕
            return  slots == 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}