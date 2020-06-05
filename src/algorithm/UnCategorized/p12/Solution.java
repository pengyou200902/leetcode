package algorithm.UnCategorized.p12;

public class Solution {
    public String intToRoman(int num) {
        // char[] roman = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        // int[] count = new int[]

        StringBuilder sb = new StringBuilder();
//        int tmp = num;
        int i, t;
        if(num >= 1000) {
            t = num/1000;
            for(i=0; i < t; i++) {
                sb.append('M');
            }
            num %= 1000;
        }
        else if(num >= 900) {
            t = num/900;
            for(i=0; i < t; i++) {
                sb.append("CM");
            }
            num %= 900;
        }
        else if(num >= 500) {
            t = num/500;
            for(i=0; i < t; i++) {
                sb.append('D');
            }
            num %= 500;
        }
        else if(num >= 400) {
            t = num/400;
            for(i=0; i < t; i++) {
                sb.append("CD");
            }
            num %= 400;
        }
        else if(num >= 100) {
            t = num/100;
            for(i=0; i < t; i++) {
                sb.append('C');
            }
            num %= 100;
        }
        else if(num >= 90) {
            t = num/90;
            for(i=0; i < t; i++) {
                sb.append("XC");
            }
            num %= 90;
        }
        else if(num >= 50) {
            t = num/50;
            for(i=0; i < t; i++) {
                sb.append('L');
            }
            num %= 50;
        }
        else if(num >= 40) {
            t = num/40;
            for(i=0; i < t; i++) {
                sb.append("XL");
            }
            num %= 40;
        }
        else if(num >= 10) {
            t = num/10;
            for(i=0; i < t; i++) {
                sb.append('X');
            }
            num %= 10;
        }
        else if(num >= 9) {
            t = num/9;
            for(i=0; i < t; i++) {
                sb.append("IX");
            }
            num %= 9;
        }
        else if(num >= 5) {
            t = num/5;
            for(i=0; i < t; i++) {
                sb.append('V');
            }
            num %= 5;
        }
        else if(num >= 4) {
            t = num/4;
            for(i=0; i < t; i++) {
                sb.append("IV");
            }
            num %= 4;
        }
        else if(num >= 1) {
            t = num;
            for(i=0; i < t; i++) {
                sb.append('I');
            }
            return sb.toString();
        }
        else return sb.toString();
        return sb.append(intToRoman(num)).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3999));
    }
}
