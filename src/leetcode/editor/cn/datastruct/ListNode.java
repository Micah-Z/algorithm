package leetcode.editor.cn.datastruct;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-06 20:02
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
