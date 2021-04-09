package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-27 16:05
 **/
public class Main {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            int length = Integer.parseInt(sc.nextLine().trim());
            String str = sc.nextLine().trim();
            getBestResult(str, length);
        }
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void getBestResult(String str, int length) {
        int count = 0;
        int start = 0;
        int last = length - 1;
        while (start < last) {
            if (str.charAt(start++) != str.charAt(last--)) {
                count++;
            }
        }
        start = 0;
        last = length - 1;
        char[] chars = str.toCharArray();
        if (count == 0) {
            list.add(str);
            return;
        } else if (count == 1) {
            while (start < last && count == 1) {
                if (chars[start] > chars[last]) {
                    chars[start] = chars[last];
                    count--;
                } else if (chars[start] < chars[last]){
                    chars[last] = chars[start];
                    count--;
                }
                start++;
                last--;
            }
        } else if (count > 1){
            while (start < length){
                if (chars[start] > '0'){
                    chars[start] = '0';
                    break;
                }
                start++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        list.add(sb.toString());
    }
}
