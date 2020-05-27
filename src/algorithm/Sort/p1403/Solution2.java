package algorithm.Sort.p1403;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Friende.Peng_You
 * @Date 2020-05-27 21:22
 */
public class Solution2 {
    // 用计数器来简化复杂度
    public List<Integer> minSubsequence(int[] nums) {
        int[] count = new int[101];
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
            count[num]++;
        }

        int currSum = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = count.length-1; i >= 0; i--) {
            while(count[i] > 0) {
                ans.add(i);
                currSum += i;
                count[i]--;
                if (currSum > totalSum - currSum) {
                    i = -1;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
