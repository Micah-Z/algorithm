package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-26 13:18
 **/
public class InPutAndOutPut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(num);
        int i = 0;
        List<List<Integer>> list = new ArrayList<>();
        while (i < 4){
            List<Integer> l = new ArrayList<>();
            l.add(scanner.nextInt());
            l.add(scanner.nextInt());
            l.add(scanner.nextInt());
            list.add(l);
            i++;
        }
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }

    }
}
