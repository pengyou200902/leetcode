package algorithm.June2020.Week1.p5;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-05 20:58
 */
public class Solution {
    private int[] sumW;
    private Random rand;

    public Solution(int[] w) {
        rand = new Random();
        if (w.length < 1)   throw new IllegalArgumentException();
        else if (w.length == 1)   this.sumW = w;
        else {
            for(int i = 1; i < w.length; i++) {
                w[i] += w[i - 1];
            }
            this.sumW = w;
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(this.sumW[this.sumW.length - 1]) + 1;
        return binarySearch(target, this.sumW);
//        int ans = Arrays.binarySearch(this.sumW, target);
//        return ans > 0 ? ans : -ans - 1;
    }

    private int binarySearch(int target, int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid = 0;
        while(l < r) {
            mid = l + ((r - l) >> 1);
            if (target > nums[mid]) {
                l = mid + 1;
            }
            else if (target < nums[mid]) {
                r = mid;
            }
            else {
                return mid;
            }
        }
        if (target > nums[r])   return r + 1;
        else if (target > nums[l])    return r;
        else return l;
    }
}
