//请你实现一个数据结构支持以下操作： 
//
// 
// Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。 
// Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否则使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任
//何事情。key 保证不为空字符串。 
// GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串"" 。 
// GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。 
// 
//
// 
//
// 挑战： 
//
// 你能够以 O(1) 的时间复杂度实现所有操作吗？ 
// Related Topics 设计 
// 👍 88 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AllOoneDataStructure {
    public static void main(String[] args) {
        AllOne solution = new AllOoneDataStructure().new AllOne();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class AllOne {


        private Map<String, Integer> map;

        private Deque<String> stack;


        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            map = new HashMap<>();
            stack = new LinkedList<>();
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (map.containsKey(key)) {
                Integer oldVal = map.get(key);
                map.replace(key, oldVal, oldVal + 1);
                if (oldVal + 1 >= map.get(stack.peekLast())){
                    stack.remove(key);
                    stack.offerLast(key);
                }
            } else {
                map.put(key, 1);
                stack.offerFirst(key);
            }
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            if (!map.containsKey(key)){
                return;
            }
            Integer integer = map.get(key);
            if (integer == 1) {
                map.remove(key, integer);
                stack.remove(key);
            } else {
                map.replace(key, integer, integer - 1);
                if (integer - 1 < map.get(stack.peekFirst())){
                    stack.remove(key);
                    stack.offerFirst(key);
                }
            }
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            return stack.peekLast() == null ? "" : stack.peekLast();
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            return stack.peekFirst() == null ? "" : stack.peekFirst();
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
//leetcode submit region end(Prohibit modification and deletion)

}