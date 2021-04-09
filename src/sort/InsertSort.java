package sort;

import sort.base.Sort;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-24 21:01
 **/
public class InsertSort<T extends Comparable<T>> extends Sort<T> {


    /**
     * 插入排序,与冒泡排序相反,使前面有序
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (this.less(nums[j],nums[j-1])){
                    this.swap(nums,j,j-1);
                }
            }
        }
    }
}
