package algorithm.UnCategorized.p20;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0)    return true;
        else if (s.length() % 2 == 1)    return false;
        else if (s.charAt(0) != '(' && s.charAt(0) != '[' && s.charAt(0) != '{')    return false;
        char[] stack = new char[s.length()];
        char x;
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            x = s.charAt(i);
            switch (x) {
                case ')':
                    if (stack[--top] == '(') continue;
                    else return false;
                    
                case '}':
                    if (stack[--top] == '{') continue;
                    else return false;
                    
                case ']':
                    if (stack[--top] == '[') continue;
                    else return false;
                    
                default:
                    stack[top++] = x;
            }
        }
//        Stack<Character> stack = new Stack<>();
//        for (char x : s.toCharArray()) {
//            switch (x) {
//                case ')':
//                    if (stack.peek() == '(') stack.pop();
//                    else return false;
//                    continue;
//                case '}':
//                    if (stack.peek() == '{') stack.pop();
//                    else return false;
//                    continue;
//                case ']':
//                    if (stack.peek() == '[') stack.pop();
//                    else return false;
//                    continue;
//                default:
//                    stack.push(x);
//            }
//        }
//        return stack.size() == 0;
        return top == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("){"));


    }

}
