package algorithm.Sort.p1403;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Solution {
    /**
     * @param nums
     * @author: Friende.Peng_You
     * @createDate: 2020/5/27 21:17
     * @return: java.util.List<java.lang.Integer>
     */
    public List<Integer> minSubsequence(int[] nums) {
        int i = 0, j = nums.length;
        if (j == 1) {
            return Arrays.asList(nums[0]);
        }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int sum1 = sum(nums, i, j);
        int sum2 = 0;
        do {
            ans.add(nums[j - 1]);
            sum2 += nums[j - 1];
            sum1 -= nums[j - 1];
//            sum1 = sum(nums, i, j);
            if (sum1 >= sum2) {
                j--;
            }
            else {
                break;
            }
        }while (j > -1);
        return ans;
    }

    /**
     * @param nums
     * @param start
     * @param end
     * @author: Friende.Peng_You
     * @createDate: 2020/5/27 21:19
     * * @return: int
     */
    private int sum(int[] nums, int start, int end) {
        if (start > end || start < 0 || end > nums.length) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,3,10,9,8};
        for (int x :
                solution.minSubsequence(nums)) {
            System.out.printf("%d,", x);
        }
    }
}