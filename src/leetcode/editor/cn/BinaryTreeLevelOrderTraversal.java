//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 812 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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


    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        // 使用栈来解决
        Deque<TreeNode> firstStack = new LinkedList<>();

        // 这个辅助栈可以使用一个size大小来省略,对应的操作就是第二个while循环中只需要循环firstStack的大小的次数
        // 将上层数据出队列,需要注意的是,使用这种方法需要使用对队列的操作,而不是栈的操作
        Deque<TreeNode> secondStack = new LinkedList<>();

        firstStack.offerLast(root);

        while (!firstStack.isEmpty() || !secondStack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (!firstStack.isEmpty()){
                TreeNode last = firstStack.pollLast();
                secondStack.offerLast(last);
                list.add(last.val);
            }
            res.add(list);
            while (!secondStack.isEmpty()){
                TreeNode last = secondStack.pollLast();
                if (last.right != null){
                    firstStack.offerLast(last.right);
                }
                if (last.left != null){
                    firstStack.offerLast(last.left);
                }
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }