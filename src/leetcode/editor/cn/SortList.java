//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1075 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

public class SortList{
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();
        ListNode node = new ListNode(3,null);
        ListNode node1 = new ListNode(1,node);
        ListNode node2 = new ListNode(2,node1);
        ListNode node3 = new ListNode(4,node2);
        solution.sortList(node3);
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
    public ListNode sortList(ListNode head) {

        // 思路:使用归并排序,递归将链表对半分,然后再归并排序
        // 链表对半分使用双指针
        if (head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        while (second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        // 中点的位置就是first指针的位置,从first这儿断开
        ListNode temp = first.next;
        first.next = null;
        ListNode left = this.sortList(head);
        ListNode right = this.sortList(temp);
        ListNode newHead = this.merge(left,right);
        return newHead;

    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0,null);
        ListNode res = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                dummy.next = left;
                left = left.next;
            }else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        if (left == null){
            dummy.next = right;
        }else {
            dummy.next = left;
        }
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }