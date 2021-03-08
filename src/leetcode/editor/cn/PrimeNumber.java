package leetcode.editor.cn;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-06 19:06
 **/
public class PrimeNumber {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long maxValue = Integer.MAX_VALUE;
        boolean isPrime = true;
        System.out.println(maxValue);
        long count = 3;
        for (int i = 4; i < 5000000; i++) {
            isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end - start);
    }
}
