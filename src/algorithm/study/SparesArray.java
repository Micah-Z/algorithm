package algorithm.study;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-11 11:47
 **/
public class SparesArray {
    public static void main(String[] args) {
        Solution getSparesArray = new SparesArray().new Solution();
        getSparesArray.toSparesArray(null);
    }

    class Solution {
        public int[][] toSparesArray(Integer[][] nums) {
            int row = nums.length;
            int column = nums[0].length;
            int count = 0;
            for (Integer[] num : nums) {
                for (Integer integer : num) {
                    if (integer != 0) {
                        count++;
                    }
                }
            }
            int[][] sparesArray = new int[count + 1][3];
            sparesArray[0][0] = row;
            sparesArray[0][1] = column;
            sparesArray[0][2] = count;

            int newRow = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] != 0){
                        sparesArray[newRow][0] = i;
                        sparesArray[newRow][1] = j;
                        sparesArray[newRow][2] = nums[i][j];
                        newRow++;
                    }
                }
            }
            return sparesArray;
        }


        public int[][] getTwoDimensional(int[][] nums){
            int[][] originalArray = new int[nums[0][0]][nums[0][1]];
            for (int i = 1; i < nums.length; i++) {
               originalArray[nums[i][0]][nums[i][1]] = nums[i][2];
            }
            return originalArray;
         }


    }
}
