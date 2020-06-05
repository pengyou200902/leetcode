package algorithm.UnCategorized.p13;

import java.util.HashMap;

public class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        int sum = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length();) {
            if (i < s.length()-1 && m.get(c[i]) < m.get(c[i+1])) {
                sum += m.get(c[i+1])-m.get(c[i]);
                i += 2;
            }
            else {
                sum += m.get(c[i]);
                i++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("LVIII"));
    }
}
