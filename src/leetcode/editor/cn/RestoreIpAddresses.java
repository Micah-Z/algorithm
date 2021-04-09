//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 538 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("101023");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();
        int[] ipSegment = new int[4];
        public List<String> restoreIpAddresses(String s) {
            this.getResult(s,0,0);
            return res;
        }

        private void getResult(String ipStr, int ipSegmentIndex, int end) {
            if (ipSegmentIndex == 4){
                // 找到了最后一个
                if (end == ipStr.length()){
                    // 如果此时刚好将ipStr遍历完了,符合条件
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < 4; i++) {
                        sb.append(ipSegment[i]);
                        if (i != 3){
                            sb.append(".");
                        }
                    }

                    res.add(sb.toString());
                }
                return;
            }

            // 没有找到所有符合条件的地址就已经边你完了字符串就直接返回
            if (end == ipStr.length()){
                return;
            }

            // 第一个是0那么这一段只能为0,直接进入下一次递归
            if (ipStr.charAt(end) == '0'){
                ipSegment[ipSegmentIndex] = 0;
                getResult(ipStr,ipSegmentIndex + 1,end + 1);
            }

            // 处理一般情况
            int s = 0;
            for (int i = end; i < ipStr.length(); i++) {
                s = s * 10 + ipStr.charAt(i) - '0';
                if (s > 0 && s <= 255){
                    ipSegment[ipSegmentIndex] = s;
                    getResult(ipStr,ipSegmentIndex + 1,i + 1);
                }else {
                    break;
                }
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}