//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1558 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    private ListNode getListNode(ListNode head) {
        // 前驱节点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;

        while (cur != null) {
            // 获取当前节点的下一个节点
            ListNode next = cur.next;
            // 将当前节点的下一个节点的next属性指向当前节点
            cur.next = pre;
            // 指针移动
            pre = cur;
            cur = next;
        }
        return pre;
    }
}