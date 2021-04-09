//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 963 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ValidateBinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {


        public boolean isValidBST(TreeNode root) {
            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    class Solution1 {


        public boolean isValidBST(TreeNode root) {
            // 使用栈的中序遍历,在遍历中先记录前一个节点的值,对于二叉搜索树来说,左节点的值<根节点的值<右节点的值
            // 该方法中先输出做左节点的值然后记录该值,再遍历根节点的值
            Deque<TreeNode> stack = new LinkedList<>();

            long val = Long.MIN_VALUE;

            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.offerLast(root);
                    root = root.left;
                } else {
                    TreeNode last = stack.pollLast();
                    if (last.val <= val) {
                        return false;
                    }
                    val = last.val;
                    root = last.right;
                }
            }

            return true;

        }
    }

}