//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 648 👎 0


package leetcode.editor.cn;

public class CountPrimes {
    public static void main(String[] args) {
        Solution solution = new CountPrimes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            if (n <= 2){
                return 0;
            }
            int[] isPrimes = new int[n];
            isPrimes[0] = isPrimes[1] = 1;
            isPrimes[2] = 0;
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (isPrimes[i] == 0){
                    for (int j = 2; j * i < n; j++) {
                        isPrimes[j * i] = 1;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (isPrimes[i] == 0){
                    sum = sum + 1;
                }
            }

            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}