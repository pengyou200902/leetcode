package algorithm.String.p1221;

public class Solution {
    public int balancedStringSplit(String s) {
        int r = 0;
        int l = 0;
        int count = 0;
        char x, y;
//        for (int i = 0; i < s.length()-1; i++) {
//            String t = s.substring(i,)
//        }
        for (int i = 0; i < s.length()-1;) {
            r = 0;
            l = 0;
            if (s.charAt(i) == 'L') {
                l++;
            }
            else if (s.charAt(i) == 'R') {
                r++;
            }
            for (int j = i+1; j < s.length();j++) {
                if (s.charAt(j) == 'L') {
                    l++;
                }
                else if (s.charAt(j) == 'R') {
                    r++;
                }
                if (l == r && l != 0) {
                    System.out.print("\t" + s.substring(i, j+1));
                    count++;
                    i = j + 1;
                    break;
                }
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new Solution().balancedStringSplit("RLLLLRRRLR"));
        System.out.println(new Solution().balancedStringSplit("LLLLRRRR"));
        System.out.println(new Solution().balancedStringSplit("RLRRRLLRLL"));
//        System.out.println("RLRRLLRLRL".substring(0,1));
    }
}
