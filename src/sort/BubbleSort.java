package sort;

import sort.base.Sort;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-24 20:49
 **/
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

    /**
     * 保证后面的元素有序,外循环从后面开始循环
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        boolean isSort = false;
        int length = nums.length;
        // 第二个检测,是一种优化,如果没有交换元素就说明已经有序了,直接退出循环
        for (int i = length - 1; i >= 0 && !isSort ; i--) {
            isSort = true;
            for (int j = 0; j < i; j++) {
                if (less(nums[j + 1], nums[j])){
                    // 有交换元素,说明无序
                    isSort = false;
                    this.swap(nums,j,j+1);
                }
            }
        }
    }
}
