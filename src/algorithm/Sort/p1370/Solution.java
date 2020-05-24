package algorithm.Sort.p1370;

/**
 * @Author Friende.Peng_You
 * @Date 2020-05-24 21:13
 */
public class Solution {
    /*
     *
     * @param s
     * @author: Friende.Peng_You
     * @createDate: 2020/5/24 21:21
     * @return: * @return: java.lang.String
     * @ref:    https://leetcode.com/problems/increasing-decreasing-string/discuss/531811/JavaPython-3-Two-clean-codes-w-explanation-and-analysis.
     */
    public String sortString(String s) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        while(ans.length() < s.length()) {
            add(count, ans, true);
            add(count, ans, false);
        }
        return ans.toString();
    }

    private void add(int[] count, StringBuilder ans, boolean asc) {
        for (int i = 0; i < 26; i++) {
            int j = asc ? i : 25 - i;
            if (count[j]-- > 0) {
                ans.append((char)(j + 'a'));
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortString("aaaabbbbcccc"));
        System.out.println(solution.sortString("rat"));
        System.out.println(solution.sortString("leetcode"));
        System.out.println(solution.sortString("ggggggg"));
    }
}
