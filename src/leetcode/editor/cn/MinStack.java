//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 847 👎 0


package leetcode.editor.cn;

import java.util.*;

public class MinStack {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    /*class MinStack {

        private List<Integer> stack;

        private List<Integer> minStack;

        private int head;

        *//**
         * initialize your data structure here.
         *//*
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            head = -1;
        }

        public void push(int val) {
            if (head == -1) {
                stack.add(val);
                minStack.add(val);
            } else {
                stack.add(val);
                minStack.add(Math.min(val, minStack.get(head)));
            }
            head++;
        }

        public void pop() {
            stack.remove(head);
            minStack.remove(head);
            head--;
        }

        public int top() {
            return stack.get(head);
        }

        public int getMin() {
            return minStack.get(head);
        }
    }*/

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
//leetcode submit region end(Prohibit modification and deletion)

    class MinStack1 {

        private List<Integer> stack;

        // 使用一个栈来放置当一个数入栈的时候与他对应的最小的数
        private Deque<Integer> minQueue;


        private int head;


        /**
         * initialize your data structure here.
         */
        /*public MinStack() {
            stack = new ArrayList<>();
            head = -1;
            minQueue = new LinkedList<>();
        }*/

        public void push(int val) {
            if (head == -1) {
                stack.add(val);
                head++;
                minQueue.offerLast(val);
            } else {
                stack.add(val);
                head++;
                minQueue.offerLast(Math.min(val, minQueue.peekLast()));
            }
        }

        public void pop() {
            stack.remove(head);
            head--;
            minQueue.pollLast();
        }

        public int top() {
            return stack.get(head);
        }

        public int getMin() {
            return minQueue.peekLast();
        }
    }

}