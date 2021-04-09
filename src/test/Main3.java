package test;

import java.util.*;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-27 17:35
 **/
public class Main3 {
    public static void main(String[] args) {
        Map<String, List<Integer>> res = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int num1 = Integer.parseInt(line1[0]);
        int num2 = Integer.parseInt(line1[1]);
        String[] line2 = sc.nextLine().split(" ");
        for (int i = 0; i < line2.length; i++) {
            if (res.containsKey(line2[i])) {
                List<Integer> list = res.get(line2[i]);
                list.add(i + 1);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                res.put(line2[i],list);
            }
        }
        String[] nums = new String[num2];
        for (int i = 0; i < num2; i++) {
            String trim = sc.nextLine().trim();
            nums[i] = trim;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (String num : nums) {
            List<Integer> list = new ArrayList<>();
            if (!res.containsKey(num)){
                list.add(0);
                result.add(list);
                continue;
            }
            List<Integer> integerList = res.get(num);
            if (integerList.size() == 1){
                list.add(integerList.get(0));
                list.add(integerList.get(0));
            }else {
                list.add(integerList.get(0));
                list.add(integerList.get(integerList.size() - 1));
            }
            result.add(list);
        }
        for (List<Integer> list : result) {
            if (list.size() == 1){
                System.out.println(list.get(0));
            }else {
                System.out.println(list.get(0) + " " + list.get(1));
            }
        }
    }
}
