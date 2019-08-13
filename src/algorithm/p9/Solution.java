package algorithm.p9;

public class Solution {
    public boolean isPalindrome(int x) {
//        if(x < 0) return false;
//        String s = String.valueOf(x);
//        String rev = new StringBuilder().append(s).reverse().toString();
//        return s.equals(rev);
        if(x < 0 || (x%10 == 0 && x!=0)) return false;
        int ori = x, rev = 0;
        while(x > 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return ori == rev;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(12121));
    }
}