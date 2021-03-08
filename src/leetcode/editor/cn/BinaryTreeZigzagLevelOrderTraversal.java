//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，
// 以此类推，层与层之间交替进行）。
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 388 👎 0


package leetcode.editor.cn;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        int i = 0;
        l.add(root.val);
        if (root.left != null){
            stack.push(root.left);
        }
        if (root.right != null){
            stack.push(root.right);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(l);
        while (!queue.isEmpty() || !stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                list.add(node.val);
                queue.add(node);
            }
            res.add(list);
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (i % 2 == 0){
                    if (poll.right != null){
                        stack.push(poll.right);
                    }
                    if (poll.left != null){
                        stack.push(poll.left);
                    }
                }else {
                    if (poll.left != null){
                        stack.push(poll.left);
                    }
                    if (poll.right != null){
                        stack.push(poll.right);
                    }
                }
            }
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }