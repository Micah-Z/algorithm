package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-26 13:58
 **/
public class InPutAndOutPut1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(num);
        int i = 0;
        while (i < 4){
            String[] strings = scanner.nextLine().split(" ");
            System.out.println(Arrays.toString(strings));
            i++;
        }

    }
}
