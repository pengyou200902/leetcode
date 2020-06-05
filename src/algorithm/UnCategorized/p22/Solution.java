package algorithm.UnCategorized.p22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n < 1)    return null;
        StringBuilder sb = new StringBuilder();
        List<String> ret = new ArrayList<>();
        addBrasket(ret, sb.append('('), n - 1, n);
        return ret;
    }

    private void addBrasket(List<String> ret, StringBuilder sb, int l, int r) {
        if (l < 0 || r < 0) return;
        else if (l == 0 && r == 0) ret.add(sb.toString());
        else if(l <= r) {
            StringBuilder bro = new StringBuilder(sb);
            addBrasket(ret, sb.append('('), l - 1, r);
            addBrasket(ret, bro.append(')'), l, r - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ret = new Solution().generateParenthesis(n);

        for (String s :
                ret) {
            System.out.println(s);
        }
    }
}
