//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 973 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        private Map<Integer,Integer> indexMap = new HashMap<>();
        private int preOrderRootIndex;
        private int[] preOrder;
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preOrder = preorder;
            this.preOrderRootIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                this.indexMap.put(inorder[i],i);
            }
            return this.getTree(0,inorder.length-1);
        }

        private TreeNode getTree(int leftIndex, int rightIndex) {
            if (leftIndex > rightIndex){
                return null;
            }
            TreeNode root = new TreeNode(this.preOrder[this.preOrderRootIndex]);
            int inOrderRootIndex = this.indexMap.get(this.preOrder[this.preOrderRootIndex]);
            this.preOrderRootIndex++;
            root.left = this.getTree(leftIndex,inOrderRootIndex - 1);
            root.right = this.getTree(inOrderRootIndex + 1,rightIndex);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}