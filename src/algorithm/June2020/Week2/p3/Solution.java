package algorithm.June2020.Week2.p3;


/**
 * @Author Friende.Peng_You
 * @Date 2020-06-10 22:06
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid])  return mid;
            else if (target > nums[mid])  {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
