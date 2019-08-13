package algorithm.p11;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int i, j;
        for(i=0, j=height.length-1; i<j;) {
            if(height[i] < height[j]) {
                max = Math.max(height[i] * (j - i), max);
                i++;
            }
            else {
                max = Math.max(height[j] * (j - i), max);
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
