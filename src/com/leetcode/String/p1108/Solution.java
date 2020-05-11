package com.leetcode.String.p1108;

public class Solution {
    public String defangIPaddr(String address) {
        StringBuilder addr = new StringBuilder();
        char x;
        for (int i = 0; i < address.length(); i++) {
            x = address.charAt(i);
            if (x == '.') {
                addr.append("[.]");
            }
            else {
                addr.append(x);
            }
        }
        return addr.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().defangIPaddr("1.1.1.1"));
        System.out.println(new Solution().defangIPaddr("255.100.50.0"));
    }

}
