//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1255 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4,node1);
        ListNode node3 = new ListNode(3,node2);
        ListNode node4 = new ListNode(2,node3);
        ListNode node5 = new ListNode(1,node4);
        solution.removeNthFromEnd(node5,2);



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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        /*int size = 0;
        ListNode copyHead = head;
        while (head != null){
            size ++;
            head = head.next;
        }
        head = copyHead;
        if (size == n){
            head = head.next;
            return head;
        }
        int end = size - n;
        int start = 1;
        while (start < end){
            head = head.next;
            start++;
        }
        head.next = head.next.next;
        head = copyHead;
        return head;*/

        // 方法二,双指针
        ListNode dummy = new ListNode(0,head);
        ListNode first = dummy;
        ListNode second = head;

        // 让second的距离与first的距离恰好为n,此时first指针在倒数第n个节点的前一个节点,因为前面有一个dummy节点
        for (int i = 0; i < n; i++) {
            second = second.next;
        }

        while (second != null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }