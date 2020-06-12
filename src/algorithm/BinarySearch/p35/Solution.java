package algorithm.BinarySearch.p35;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-12 14:36
 */
public class Solution {
    // public int searchInsert(int[] nums, int target) {
    //     int s = 0, e = nums.length;
    //     while(s < e){
    //         int mid = (s + e) / 2;
    //         if(nums[mid] < target){
    //             s = mid + 1;
    //         }else{
    //             e = mid;
    //         }
    //     }
    //     return s;
    // }
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
