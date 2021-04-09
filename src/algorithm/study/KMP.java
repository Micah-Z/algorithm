package algorithm.study;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-28 13:42
 **/
public class KMP {
    public static void main(String[] args) {
        Sulation sulation = new KMP().new Sulation();
        sulation.KmpAlgorithm("adcadcaddcadde","adcadde");
    }


    class Sulation{
        public void KmpAlgorithm(String original,String pattern){
            int[] nextVal = this.getNextVal(pattern);
            int index = this.select(original,pattern,nextVal);
            System.out.println(index);
        }

        private int select(String original, String pattern, int[] nextVal) {
            int length = original.length();
            int pLength = pattern.length();
            if (length < pLength){
                return -1;
            }
            int op = 0;
            int p = 0;
            while (op < length && p < pLength) {
                if (original.charAt(op) == pattern.charAt(p)){
                    op++;
                    p++;
                    if (p == pLength){
                        return op - pLength;
                    }
                }else if (p == 0){
                    op++;
                }else if (original.charAt(op) != pattern.charAt(p)){
                    p = nextVal[p-1];
                }
            }
            return -1;
        }


        /**
         * 创建next数组
         * @param pattern
         * @return
         */
        private int[] getNextVal(String pattern) {
            int i = 0;
            int[] nextVal = new int[pattern.length()];
            nextVal[0] = 0;
            for (int j = 1; j < pattern.length(); j++) {
                int k = j;
                while (k > 0 && pattern.charAt(i) != pattern.charAt(j)){
                    // 如果不相等则进行回溯,一直到-1或者两个字符相等
                    i = nextVal[k - 1];
                    k = i;
                }
                // 不相等才减一,i的初始值为-1,下面有一个加一的操作
                if (pattern.charAt(i) != pattern.charAt(j)){
                    i--;
                }
                i++;
                nextVal[j] = i;
            }
            return nextVal;
        }
    }
}
