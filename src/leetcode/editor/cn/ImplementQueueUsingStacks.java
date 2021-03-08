//请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）： 
//
// 实现 MyQueue 类： 
//
// 
// void push(int x) 将元素 x 推到队列的末尾 
// int pop() 从队列的开头移除并返回元素 
// int peek() 返回队列开头的元素 
// boolean empty() 如果队列为空，返回 true ；否则，返回 false 
// 
//
// 
//
// 说明： 
//
// 
// 你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
// 
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。 
// 
//
// 
//
// 进阶： 
//
// 
// 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 1, 1, false]
//
//解释：
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用 100 次 push、pop、peek 和 empty 
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作） 
// 
// Related Topics 栈 设计 
// 👍 285 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue solution = new ImplementQueueUsingStacks().new MyQueue();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        solution.pop();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MyQueue {

        private  Deque<Integer> firststack;

        private  Deque<Integer> secondstack;

        private int front;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            this.firststack = new LinkedList<>();

            this.secondstack = new LinkedList<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            if (this.firststack.isEmpty()){
                // 这里只记录栈底的元素
                this.front = x;
            }
            this.firststack.addFirst(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            // 主要的思路是将两个栈摊分来存储数据
            if (this.secondstack.isEmpty()){
                while (!this.firststack.isEmpty()){
                    this.secondstack.push(this.firststack.pop());
                }
            }
            return this.secondstack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!this.secondstack.isEmpty()){
                return this.secondstack.peek();
            }
            return front;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return this.secondstack.size() == 0 && this.firststack.size() == 0;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}