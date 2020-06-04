package algorithm.June2020.Week1.p4;

import java.util.Arrays;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-04 22:49
 */
public class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        if (j == 0) return;
        while(i < j) {
            s[i] ^= s[j];
            s[j] = (char)(s[i] ^ s[j]);
            s[i] ^= s[j];
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char[] s1 = {'H','a','n','n','a','h'};
        char[] s2 = {'h','e','l','l','o'};
        Solution solution = new Solution();
        solution.reverseString(s1);
        solution.reverseString(s2);
        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));
    }
}
