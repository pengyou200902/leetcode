package algorithm.String.p1003;

import java.util.Stack;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-15 22:13
 * @Reference https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/discuss/247626/JavaPythonC%2B%2B-Stack-Solution-O(N)
 * @Reference https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/discuss/247643/Java-3-lines-solution
 */
public class Solution {
    public boolean isValid(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c: S.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b')    {return false;}
                if (stack.isEmpty() || stack.pop() != 'a')    {return false;}
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

//    public boolean isValid(String S) {
//        String abc = "abc";
//
//        while(S.contains(abc)) {
//            S = S.replace(abc, "");
//        }
//
//        return S.isEmpty();
//    }

}
