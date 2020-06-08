package algorithm.BitManipulation.p1342;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-08 23:36
 */
public class Solution {

    public int numberOfSteps (int num) {

        int count = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num -= 1;
            }
            else {
                num >>= 1;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(4&1);
//        System.out.println(7&1);
        System.out.println(new Solution().numberOfSteps(14));
        System.out.println(new Solution().numberOfSteps(8));
        System.out.println(new Solution().numberOfSteps(123));
    }

}
