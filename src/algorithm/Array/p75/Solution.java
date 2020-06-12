package algorithm.Array.p75;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-11 22:52
 * @Reference https://leetcode.com/problems/sort-colors/discuss/26472/Share-my-at-most-two-pass-constant-space-10-line-solution
 * 见评论一
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)    return;

        int low = 0, high = nums.length - 1;
        for (int i = low; i <= high;) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                i++;
                low++;
            }
            else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            }
            else i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
