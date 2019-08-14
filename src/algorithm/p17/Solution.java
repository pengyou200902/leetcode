package algorithm.p17;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;

//        HashMap<String, Character[]> keys = new HashMap<>();
//        keys.put("2", new Character[]{'a', 'b', 'c'});
//        keys.put("3", new Character[]{'d', 'e', 'f'});
//        keys.put("4", new Character[]{'g', 'h', 'i'});
//        keys.put("5", new Character[]{'j', 'k', 'l'});
//        keys.put("6", new Character[]{'m', 'n', 'o'});
//        keys.put("7", new Character[]{'p', 'q', 'r', 's'});
//        keys.put("8", new Character[]{'t', 'u', 'v'});
//        keys.put("9", new Character[]{'w', 'x', 'y', 'z'});

//        for (int i = 0; i < digits.length(); i++) {
//            if (digits.charAt(i) > '1' && digits.charAt(i) <= '9') {
//
//            }
//
//        }
//        return ans;
    }

    public static void main(String[] args) {
//        System.out.println('9' - '1' + 2);
        String digits = "23";
        List<String> ans = new Solution().letterCombinations(digits);
        for (String s :
                ans) {
            System.out.println(s);
        }
    }
}
