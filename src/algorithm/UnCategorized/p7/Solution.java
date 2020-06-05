package algorithm.UnCategorized.p7;

public class Solution {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();
        boolean pos;
        if(x < 0) {
            pos = false;
            sb.append(new StringBuilder().append(x).substring(1));
        }
        else {
            pos = true;
            sb.append(x);
        }
        sb = sb.reverse();
        int rev = 0;
        try {
            if (!pos) {
                sb = sb.insert(0, '-');
            }
            rev = Integer.valueOf(sb.toString());
        }catch (Exception e) {
            return 0;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
//        System.out.println(new StringBuilder().append(-123));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
    }
}
