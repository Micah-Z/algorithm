//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。 
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，po
//s 仅仅是用于标识环的情况，并不会作为参数传递到函数中。 
//
// 说明：不允许修改给定的链表。 
//
// 进阶： 
//
// 
// 你是否可以使用 O(1) 空间解决此题？ 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [3,2,0,-4], pos = 1
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [1,2], pos = 0
//输出：返回索引为 0 的链表节点
//解释：链表中有一个环，其尾部连接到第一个节点。
// 
//
// 示例 3： 
//
// 
//
// 
//输入：head = [1], pos = -1
//输出：返回 null
//解释：链表中没有环。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围在范围 [0, 104] 内 
// -105 <= Node.val <= 105 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
// Related Topics 链表 双指针 
// 👍 943 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            // 快慢指针解决,快指针走的步数是慢指针的两倍
            // 如果环前的距离是a环的距离是b,那么环的入口必定为a+nb,两个指针相遇此时慢指针走的距离就是nb,快指针走的距离是2nb
            ListNode slow, fast;
            slow = fast = head;
            while (true) {
                if (fast == null || fast.next == null) {
                    return null;
                }
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    break;
                }
            }
            fast = head;
            while (fast != slow){
                fast =fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            // Hash表解决
            Set<ListNode> set = new HashSet<>();
            if (head == null || head.next == null) {
                return null;
            }
            while (true) {
                if (!set.add(head)) {
                    return head;
                } else if (head == null) {
                    return null;
                }
                head = head.next;
            }
        }
    }
}