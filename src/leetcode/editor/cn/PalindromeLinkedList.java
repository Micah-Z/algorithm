//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 890 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode left = null;
    public boolean isPalindrome(ListNode head) {
        // 方法三,使用快慢指针找到链表的中点,然后再再从中间反转链表,减少空间复杂度
        ListNode slow , fast;
        slow = fast = head;
        ListNode last = null;
        while (fast != null && fast.next != null){
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果是奇数个节点的链表
        if (fast != null){
            // 慢指针要向前一步,剔除掉中间的那个节点
            last = slow;
            slow = slow.next;
        }
        // 从slow节点开始反转链表
        ListNode newHead = this.reverseList(slow);
        // 恢复链表的结构
        last.next = newHead;
        // 再判断值是否相等
        while (newHead != null){
            if (head.val != newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode slow) {
        ListNode pre = null;
        ListNode cur = slow;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            // 方法一,暴力解法,先反转链表然后比较
            // 先复制一份然后反转链表
            ListNode newHead = new ListNode(head.val);
            ListNode cur = newHead;
            ListNode head1 = head.next;
            while (head1 != null){
                ListNode node = new ListNode(head1.val);
                newHead.next = node;
                newHead = newHead.next;
                head1 = head1.next;
            }
            ListNode reverseHead = this.reverse(cur);
            while (head!= null){
                if (head.val != reverseHead.val){
                    return false;
                }
                head = head.next;
                reverseHead = reverseHead.next;
            }
            return true;

        }

        private ListNode reverse(ListNode cur) {

            if (cur == null || cur.next == null){
                return cur;
            }
            ListNode last = this.reverse(cur.next);
            cur.next.next = cur;
            cur.next = null;
            return last;
        }
    }

    class Solution2 {
        ListNode left = null;
        public boolean isPalindrome(ListNode head) {
            // 方法二,运用树的后序遍历性质
            left = head;
            return this.postOrderTraversal(head);

        }

        private boolean postOrderTraversal(ListNode head) {
            if (head == null){
                return true;
            }
            boolean res = this.postOrderTraversal(head.next);
            res = res && (head.val == left.val);
            left = left.next;
            return res;
        }

    }

  }