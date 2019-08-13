package algorithm.p14;

import java.util.Arrays;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)   return "";
        Arrays.sort(strs);
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length-1].charAt(i))
                return strs[strs.length-1].substring(0, i);
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"123"}));
    }

}
