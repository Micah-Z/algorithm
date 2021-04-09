package sort;

import sort.base.Sort;

/**
 * @program: leetcode
 * @description: 快速排序,选中一个节点,将比他的大移到它的右边,比他小的移到它的左边
 * @author: Micah
 * @create: 2021-03-25 15:49
 **/
public class QuickSort<T extends Comparable<T>> extends Sort<T> {



    @Override
    public void sort(T[] nums) {
        this.sort(nums,0,nums.length-1);
    }

    private void sort(T[] nums, int start, int end) {
        if (start >= end){
            return;
        }
        // 获取关键节点的位置(节点的左边比他小,节点的右边比他大)
        int position = this.getPosition(nums,start,end);
        // 对节点左边再次递归调用排序
        this.sort(nums,start,position);
        // 对节点右边进行递归调用排序
        this.sort(nums,position+1,end);
    }

    private int getPosition(T[] nums, int start, int end) {
        T keyVal = nums[start];
        int l = start;
        int r = end;
        do {
            // 从左往右遍历,找到比关键节点大的值
            while (l != end) {
                if (less(keyVal, nums[l])) {
                    break;
                }
                l++;
            }
            // 从右往左遍历找到比关键值小的值
            while (r != start) {
                if (less(nums[r], keyVal)) {
                    break;
                }
                r--;
            }
            // 如果右边的指针大于左边的指针,则将找到的两个值交换
            if (r > l){
                this.swap(nums,r,l);
            }
        } while (r > l);
        // 最后将关键值交换过去,使关键值得左边都小于他,关键值得右边都大于他
        this.swap(nums,start,r);
        return r;
    }
}
