package algorithm.p10;
import java.util.regex.*;

public class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(s);
        return m.matches();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("", ""));
    }
}
