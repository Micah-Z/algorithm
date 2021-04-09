package sort.main;

import sort.HeapSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.ShellSort;
import sort.base.Sort;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-24 21:39
 **/
public class SortMain {
    public static void main(String[] args) {
        Integer[] num = {1,9,5,6,7,16,8,20,5,0,8,6,3};
        Sort<Integer> sort = new ShellSort<>();
        // Sort<Integer> sort = new MergeSort<>();
        // Sort<Integer> sort = new QuickSort<>();
        // Sort<Integer> sort = new HeapSort<>();
        sort.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
