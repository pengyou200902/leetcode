package com.leetcode.Sort.p350;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0;
        int size = 0;
        HashMap<Integer ,Integer> a = count(nums1);
        HashMap<Integer ,Integer> b = count(nums2);
        HashMap<Integer ,Integer> resultCount = new HashMap<>();
        for (Integer key : a.keySet()) {
            if (b.get(key) != null) {
                int _count = a.get(key) < b.get(key) ? a.get(key) : b.get(key);
                resultCount.put(key, _count);
                size += _count;
            }
        }
        int[] result = new int[size];
        for (Integer key : resultCount.keySet()) {
            int quantity = resultCount.get(key);
            int stop = i + quantity;
            while(i < stop) {
                result[i] = key;
                i++;
            }
        }
        return result;
    }

    public HashMap<Integer ,Integer> count(int[] nums) {
        HashMap<Integer ,Integer> a = new HashMap<>();
        for (int num : nums) {
//            a.merge(num, 1, Integer::sum);
            a.put(num, a.getOrDefault(num,0)+1);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
