//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 
// 👍 386 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeIi{
    public static void main(String[] args) {
        Solution solution = new PopulatingNextRightPointersInEachNodeIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        if (root.left != null){
            if (root.right != null){
                root.left.next = root.right;
            }else if (root.next != null){
                Node temp = root.next;
                while (temp != null){
                    if (temp.left != null){
                        root.left.next = temp.left;
                        break;
                    }else if (temp.right != null){
                        root.left.next = temp.right;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
        if (root.right != null) {
            if (root.next != null) {
                if (root.next.left != null) {
                    root.right.next = root.next.left;
                } else if (root.next.right != null) {
                    root.right.next = root.next.right;
                } else {
                    root.right.next = null;
                }
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public Node connect(Node root) {
            // 层序遍历
            Deque<Node> deque = new LinkedList<>();
            if (root == null){
                return null;
            }
            if (root.left == null && root.right == null){
                return root;
            }
            if (root.left != null){
                deque.offerLast(root.left);
            }
            if (root.right != null){
                deque.offerLast(root.right);
            }
            while (!deque.isEmpty()){
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    Node firstNode = deque.pollFirst();
                    if (i == size - 1){
                        firstNode.next = null;
                    }else {
                        firstNode.next = deque.peekFirst() == null ? null : deque.peekFirst();
                    }
                    if (firstNode.left != null){
                        deque.offerLast(firstNode.left);
                    }
                    if (firstNode.right != null){
                        deque.offerLast(firstNode.right);
                    }
                }
            }
            return root;
        }
    }
static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
  }