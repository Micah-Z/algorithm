//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1295 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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

    public boolean isSymmetric(TreeNode root) {
        // 使用队列 + 双指针来解决,首先将根节点的左右节点入队列,
        // 此时队列的两个节点就对应两个指针
        // 再将左右指针用相反的顺序入队列就行
        // 队列中的前两个节点永远都是对称的两个节点
        return this.isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(left);
        deque.offerFirst(right);

        while (!deque.isEmpty()){
            TreeNode r = deque.pollFirst();
            TreeNode l = deque.pollFirst();
            if (r == null && l == null){
                continue;
            }
            if (r == null || l == null){
                return false;
            }
            if (r.val != l.val){
                return false;
            }

            deque.offerFirst(r.right);
            deque.offerFirst(l.left);

            deque.offerFirst(r.left);
            deque.offerFirst(l.right);
        }
        return true;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {

        public boolean isSymmetric(TreeNode root) {
            // 使用递归+双指针解决,first指针和second指针
            // 起初两个指针都指向根节点,
            // 然后first往左移动,second指针往右移动
            // first指针往右移动,second指针往左移动
            // 总之就是两个指针反着移动
            return this.isSymmetric(root,root);
        }

        private boolean isSymmetric(TreeNode first, TreeNode second) {
            if (first == null && second == null){
                // 两个指针都为null
                return true;
            }
            if (first == null || second == null){
                // 两个指针其中有一个为null
                return false;
            }
            if (first.val != second.val){
                // 两个值不相等,返回false
                return false;
            }

            boolean b1 = this.isSymmetric(first.left,second.right);

            boolean b2 = this.isSymmetric(first.right,second.left);

            return b1 && b2;
        }


    }

  }