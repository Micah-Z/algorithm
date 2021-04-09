//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 643 👎 0


package leetcode.editor.cn;

public class Sqrtx {
    public static void main(String[] args) {
        Solution solution = new Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            // return (int) Math.floor(Math.sqrt(x));
            if (x == 1){
                return 1;
            }
            long start = 0;
            long end = x;
            while (start < end){
                long mid = start + (end - start)/2;
                if ((mid * mid) > x){
                    end = mid;
                }else {
                    long num = (mid + 1) * (mid + 1);
                    if (num > x || (mid * mid) == x){
                        return (int) mid;
                    }
                    start = mid + 1;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}