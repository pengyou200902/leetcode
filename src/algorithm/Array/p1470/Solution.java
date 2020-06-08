package algorithm.Array.p1470;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-08 23:14
 */
public class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];
        int[] idx = new int[2];
        idx[1] = n;

        int i = 0;
        while (i < nums.length) {
            ans[i] = nums[idx[i % 2]++];
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
