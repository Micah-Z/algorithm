//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组 
// 👍 477 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        int[] num1 = {9,3,15,20,7};
        int[] num2 = {9,15,7,20,3};
        solution.buildTree(num1,num2);
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
        private Map<Integer, Integer> indexMap = new HashMap<>();
        private int postOrderRootIndex;
        private int[] postOrder;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postOrder = postorder;
            this.postOrderRootIndex = postorder.length - 1;
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
            return this.getTree(0, inorder.length - 1);
        }

        private TreeNode getTree(int leftIndex, int rightIndex) {
            if (leftIndex > rightIndex) {
                return null;
            }
            TreeNode root = new TreeNode(this.postOrder[this.postOrderRootIndex]);
            // 在中序遍历中获取根节点的索引位置
            int inOrderRootIndex = this.indexMap.get(root.val);
            this.postOrderRootIndex--;
            // 递归的目的是判断根节点左右是否还有子节点
            // 通过中序遍历判断是否还存在左右子节点,根据后序遍历来构建树
            root.right = getTree(inOrderRootIndex + 1, rightIndex);
            root.left = getTree(leftIndex, inOrderRootIndex - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}