package algorithm.June2020.Week2.p2;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-09 21:16
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if
 * T has its subsequence. In this scenario, how would you change your code?
 *
 * @Reference https://leetcode.com/problems/is-subsequence/discuss/87302/Binary-search-solution-for-follow-up-with-detailed-comments
 */
public class Solution {
    public boolean isSubsequence(String s, String t) {
        boolean found = false;
        char x, y;
        int index = -1;
        for(int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            found = false;
            for(int j = index + 1; j < t.length(); j++) {
                y = t.charAt(j);
                if (x == y) {
                    found = true;
                    index = j;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }
}
