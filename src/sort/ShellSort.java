package sort;

import sort.base.Sort;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-24 21:19
 **/
public class ShellSort<T extends Comparable<T>> extends Sort<T> {


    /**
     * 希尔排序,分组思想
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        int segmented = length >> 1 == 0 ? 1 : length >> 1;
        while (segmented > 0){
            for (int i = 0; i + segmented < length; i++) {
                for (int j = i + segmented;  (j -segmented) >= 0; j = j - segmented) {
                    this.exchange(nums,j,j -segmented);
                }
            }
            segmented =  segmented >> 1;
        }
    }

    private void exchange(T[] nums, int i, int j) {
        if (this.less(nums[i], nums[j])){
            this.swap(nums,i,j);
        }
    }
}
