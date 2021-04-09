//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。 
//
// 说明: 
//1 ≤ m ≤ n ≤ 链表长度。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL 
// Related Topics 链表 
// 👍 704 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
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

        ListNode successor = null;

        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 递归解决方法
            if (left == 1){
                // 开始反转链表
                return this.startReverse(head,right);
            }
            // 递归找到截取节点的起始节点
            head.next = this.reverseBetween(head.next,left - 1,right - 1);
            return head;
        }

        private ListNode startReverse(ListNode head, int right) {
            if (right == 1){
                successor = head.next;
                return head;
            }
            ListNode last = this.startReverse(head.next, right - 1);
            head.next.next = head;
            head.next = successor;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
class Solution2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1,head);
        // 从虚拟节点开始，可以避免多种情况的分类讨论
        head = dummy;
        int count = 1;
        ListNode pre = null;
        ListNode last = null;

        // 获取需要截取节点的开始节点的前置节点
        for (int i = 0; i < left - 1; i++) {
            head = head.next;
        }
        pre = head;
        ListNode leftNode = pre.next;
        ListNode rightNode = head;
        // 获取截取节点的最后一个节点
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 记录截取节点右节点的下一个节点
        ListNode rightNext = rightNode.next;
        // 截断链表
        pre.next = null;
        rightNode.next = null;
        // 翻转链表,返回反转后的头节点
        ListNode reverseFirst = this.reverse(leftNode);
        pre.next = reverseFirst;
        leftNode.next = rightNext;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}

}