package algorithm.study;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-12 19:12
 **/
public class CycleArray {

    public static void main(String[] args) {
        Solution solution = new CycleArray().new Solution(5);
        solution.add(1);
        solution.add(2);
        solution.add(3);
        solution.add(4);
        solution.add(5);
       /* System.out.println("弹出" + solution.pop());
        System.out.println("弹出" + solution.pop());
        System.out.println("查看" + solution.poll());*/
        // System.out.println(solution.size());
        /*solution.add(2);
        solution.add(1);*/
       /* System.out.println(solution.size());
        System.out.println("弹出" + solution.pop());*/
        solution.pop();
        solution.pop();
        solution.pop();
        solution.add(5);
        solution.add(5);
        solution.printAll();
        System.out.println(Arrays.toString(solution.array));
    }


    class Solution {
        private Integer maxSize;

        private Integer head = 0;

        private Integer tail = 0;

        private Integer[] array;

        public Solution(Integer maxSize) {
            this.maxSize = maxSize;
            this.array = new Integer[maxSize];
        }

        public boolean isFull() {
            if (tail == 0){
                return false;
            }
            return (tail % maxSize) == head;
        }

        public boolean isEmpty() {
            return tail.equals(head);
        }

        public boolean add(Integer num) {
            if (isFull()) {
                throw new RuntimeException("队列已经满了");
            }
            array[tail % (maxSize)] = num;
            tail++;
            return true;
        }

        public Integer pop() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            Integer num = array[head % maxSize];
            head++;
            return num;
        }

        public Integer size(){
            return tail - head;
        }

        public Integer poll() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            return array[head % maxSize];
        }

        public void printAll(){
            for (int i = head; i <  head + size(); i++) {
                Integer num = array[i % maxSize];
                System.out.println(num);
            }
        }
    }
}
