package sort;

import sort.base.Sort;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 堆排序,先构建一个标准的大顶堆,再将堆顶的元素与最后一个元素交换,然后让这个现在
 * 处于堆顶的元素下沉
 * @author: Micah
 * @create: 2021-04-02 19:50
 **/
public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        // 初始化大顶堆
        this.initHeap(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        // 将堆顶的元素与最后一个元素交换,然后再不断下沉堆顶的那个元素
        while (length > 0){
            this.swap(nums,0, length - 1);
            this.sink(nums,0,--length);
        }
    }


    /**
     * 初始化一个堆
     * @param nums
     */
    public void initHeap(T[] nums){
        for (int i = (nums.length / 2 ) - 1 ; i > -1; i--) {
            sink(nums,i, nums.length);
        }
        // System.out.println(Arrays.toString(nums));
    }

    /**
     * 这个下沉操作是将小的值下沉,符合大顶堆的定义
     * 下沉操作,与左右子节点中最大的那个进行交换
     * @param nums
     * @param index 当前的根节点索引位置
     * @param length
     */
    public void sink(T[] nums,int index,int length){
        // 左子节点的位置
        while ((2 * index) + 1 < length){
            int j = 2 * index + 1;
            if (j < length - 1 && less(nums[j], nums[j + 1])){
                // 左子节点小于右子节点的话,就要上浮右子节点,而不是左子节点
                j++;
            }
            if (less(nums[j],nums[index])){
                // 左右子节点最大的那个都比根节点小,就不用交换了
                break;
            }
            this.swap(nums,index,j);
            // 指针k指向交换后的那个位置再次进行下沉操作
            index = j;
        }
    }
}
