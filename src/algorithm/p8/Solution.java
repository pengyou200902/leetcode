package algorithm.p8;

public class Solution {
    public int myAtoi(String str) {
        int i, j = 0;
        int len = str.length();
        boolean neg = false;
        for (i = 0; i < len; i++) {
            if(str.charAt(i) == '-' || str.charAt(i) == '+') {
                neg = str.charAt(i) == '-';
                i++;
                break;
            }
            else if('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            }
            else if(str.charAt(i) != ' '){ //非空格就格式错误，是空格则跳过
                return 0;
            }
        }
        for (j = i; j < len; j++) {
            if(str.charAt(j) < '0' || str.charAt(j) > '9') {
                break;
            }
        }
        int ret = 0;
        for (int k = i; k < j; k++) {
            int tmp = str.charAt(k) - '0';
            if(neg) {
                if(ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && tmp > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - tmp;
            }
            else {
                if(ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && tmp > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + tmp;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("123"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MAX_VALUE);
    }
}