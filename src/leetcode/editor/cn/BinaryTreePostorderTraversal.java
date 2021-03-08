//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 523 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        Deque<TreeNode> stack = new LinkedList<>();

        List<Integer> res = new ArrayList<>();

        // 这是记录每一次出栈了的节点,防止节点的右节点已经出栈了,但是在遍历的时候还会遍历到这个右节点,形成无限递归调用
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                if (node.right == null || node.right == pre){
                    res.add(node.val);
                    pre = node;
                }else {
                    stack.push(node);
                    root = node.right;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }