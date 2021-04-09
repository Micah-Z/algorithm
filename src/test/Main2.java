package test;

import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-27 16:56
 **/
public class Main2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(strings[0]);
        long minC = Math.min(Long.parseLong(strings[1]),Long.parseLong(strings[2]));
        String resStr = sc.nextLine().trim();
        if (n != resStr.length()){
            return;
        }
        long res = 0;
        char[] chars = resStr.toCharArray();
        for (int i = 0; i < n - 2; i++) {
            char a = chars[i];
            char b = chars[i + 1];
            char c = chars[i + 2];
            if (a == 'F' && b == 'F' && c == 'F'){
                res = res + minC;
                chars[i+1] = 'T';
            }
        }
        System.out.println(res);
    }
}
