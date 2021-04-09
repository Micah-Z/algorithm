package sort;

import sort.base.Sort;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 归并排序
 * @author: Micah
 * @create: 2021-03-24 23:24
 **/
public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] temp;

    /**
     * 思想:分而治之,先分开,再合并
     *
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        this.temp = (T[]) new Comparable[nums.length];
        // 自顶向下
        this.mergeSortTop2Bottom(nums, 0, nums.length - 1);
        // System.out.println(Arrays.toString(temp));
        // 自下向上
        // this.mergeSortBottom2Top(nums);
    }

    /**
     * 自下向上进行归并排序,先归并最小的单位,即每两个为一组进行归并,然后归并每四个一组
     *
     * @param nums
     */
    private void mergeSortBottom2Top(T[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i += i) {
            for (int j = 0; j < length - i; j += i + i) {
                this.merge(nums, j, j + i - 1, Math.min(length - 1, j + i + i - 1));
            }
        }
    }

    /**
     * 使用递归自顶向下进行分组排序
     *
     * @param nums
     * @param start
     * @param end
     */
    private void mergeSortTop2Bottom(T[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        // 使用递归使数组分组
        this.mergeSortTop2Bottom(nums, start, mid);
        this.mergeSortTop2Bottom(nums, mid + 1, end);
        // 排序并且归并,第一个进行排序归并的粒度必定是最小的
        this.merge(nums, start, mid, end);
        System.out.println(start + " " + mid + " " + end);
    }

    /**
     * @param nums
     * @param start 第一个数组的开始下标
     * @param mid   数组的中点,把一个数组分为两个数组,是第一个数组的终止下标
     * @param end   两个数组的大小,第二个数组的终止下标
     */
    private void merge(T[] nums, int start, int mid, int end) {
        // 首先对需要排序和归并的数组进行一次拷贝
        if (end + 1 - start >= 0) {
            System.arraycopy(nums, start, temp, start, end + 1 - start);
        }
        int l = start;
        int k = start;
        int r = mid + 1;
        while (k <= end) {
            // 如果l已经大于mid的值,则说明前半段数组已经排序归并完了,只需要把后半段接上就行
            if (l > mid) {
                nums[k] = temp[r++];
            } else if (r > end) {
                // 这个说明后半段已经排序归并完毕,只需要管前半段就行
                nums[k] = temp[l++];
            } else if (nums[l].compareTo(nums[r]) <= 0) {
                // 前半段和后半段比较,归并,这对应着前半段的数据小于后半段
                nums[k] = temp[l++];
            } else {
                // 这对应后半段数据小于前半段
                nums[k] = temp[r++];
            }
            k++;
        }
    }


}
