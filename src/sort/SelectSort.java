package sort;

import sort.base.Sort;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-24 20:36
 **/
public class SelectSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j].compareTo(nums[index]) < 0){
                    index = j;
                }
            }
            this.swap(nums,i,index);
        }
    }
}
