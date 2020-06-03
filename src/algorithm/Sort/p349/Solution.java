package algorithm.Sort.p349;


import java.util.HashSet;
import java.util.Set;

/**
 * @Author Friende.Peng_You
 * @Date 2020-05-27 22:01
 * Success
 * Details
 * Runtime: 2 ms, faster than 99.35% of Java online submissions for Intersection of Two Arrays.
 * Memory Usage: 40.1 MB, less than 6.75% of Java online submissions for Intersection of Two Arrays.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int x: nums1) {
            set.add(x);
        }

        for (int x: nums2) {
            if (set.contains(x)) {
                ans.add(x);
            }
        }

        int[] intersect = new int[ans.size()];
        int i = 0;
        for (int x: ans) {
            intersect[i++] = x;
        }

        return intersect;
    }

    public static void main(String[] args) {

    }
}
