package algorithm.DynamicProgramming.p368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-13 16:30
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null) {
            return null;
        }
        int[] dpCounter = new int[nums.length];
        // for(int i=0;i<nums.length;i++)  dpCounter[i]=1;
        int[] pre = new int[nums.length];
        int i = nums.length - 1;
        int j;
        int max = 0, maxIndex = 0;
        Arrays.sort(nums);
        for (i = nums.length - 1; i >= 0; i--) {
            // for (j = i+1; j < nums.length; j++) {
            for (j = i; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0 && dpCounter[i] < dpCounter[j] + 1) {
                    dpCounter[i] = dpCounter[j] + 1;
                    pre[i] = j;
                }
            }
            if (max < dpCounter[i]) {
                max = dpCounter[i];
                maxIndex = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        i = 0;
        while (i < max) {
            ans.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
            i++;
        }
        return ans;
    }
}
