//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
// 请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 882 👎 0


package leetcode.editor.cn;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> list = new ArrayList<>();
            // 关键步骤,先排序,将区间比较小的移到前面来
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            for (int i = 0; i < intervals.length; i++) {
                int L = intervals[i][0];
                int R = intervals[i][1];
                if (list.size() == 0 || list.get(list.size() - 1)[1] < L){
                    list.add(new int[]{L,R});
                }else {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],R);
                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public int[][] merge(int[][] intervals) {
            List<Integer> list = new ArrayList<>();
            int length = intervals.length;
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            list.add(intervals[0][0]);
            list.add(intervals[0][1]);
            for (int i = 1; i < length; i++) {
                if (intervals[i][0] <= list.get(0)) {
                    list.set(0, intervals[i][0]);
                    if (intervals[i][1] > list.get(1)) {
                        list.set(1, intervals[i][1]);
                    }
                } else if (intervals[i][0] <= list.get(list.size() - 1)) {
                    if (intervals[i][1] > list.get(list.size() - 1)) {
                        list.set(list.size() - 1, intervals[i][1]);
                    }
                } else {
                    list.add(intervals[i][0]);
                    list.add(intervals[i][1]);
                }
            }
            int rLength = list.size() >> 1;
            int[][] result = new int[rLength][2];
            int j = 0;
            for (int i = j = 0; i < list.size(); i = i + 2, j++) {
                result[j][0] = list.get(i);
                result[j][1] = list.get(i + 1);
            }
            return result;
        }
    }

}