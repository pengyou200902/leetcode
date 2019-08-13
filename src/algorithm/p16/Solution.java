package algorithm.p16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3)    return 0;
        int x, i, cur, min = 0;
        Arrays.sort(nums);
        min = nums[0] + nums[1] + nums[2];
        for(i = 0; i < nums.length - 2; i++) {
            int p = i+1;
            int q = nums.length - 1;
//            min = nums[i] + nums[p] + nums[q];
            while(p < q) {
                x = nums[i] + nums[p] + nums[q];
                cur = Math.abs(x - target);
                if (Math.abs(min - target) > cur) {
                    min = x;
                }
                if (x > target) {
                    q--;
                }
                else if (x < target) {
                    p++;
                }
                else return target;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0};
        int target = -100;
        System.out.println(new Solution().threeSumClosest(nums, target));


    }
}
