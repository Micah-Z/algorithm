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
// 👍 811 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MinStackMain {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {

        /**
         * initialize your data structure here.
         */

        private final List<Integer> container = new ArrayList<>();

        /**
         * 使用一个辅助栈,里面存储的元素和当前的栈的元素一样的,并且都是存储的最小的元素
         * 如果当前的container出元素,则这个栈也出元素,和container保持一致
         * 这样最上面的那个元素一定是最小的元素
         */
        private final Deque<Integer> xStack = new LinkedList<>();


        private int topIndex = -1;



        public MinStack() {

        }

        public void push(int x) {
            if (topIndex == -1){
                container.add(x);
                topIndex = topIndex + 1;
                xStack.push(x);
            }else {
                container.add(x);
                topIndex += 1;
                xStack.push(Math.min(x,xStack.peek().intValue()));
            }
        }

        public void pop() {
            container.remove(topIndex);
            topIndex -= 1;
            xStack.pop();
        }

        public int top() {
            return container.get(topIndex);
        }

        public int getMin() {
            return xStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}