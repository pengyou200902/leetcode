package algorithm.String.p67;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-12 22:44
 * @Reference https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation
 */
public class Solution {
    public String addBinary(String a, String b) {
        //two pointers starting from the back, just think of adding two regular ints from you add from back
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            //if there is a carry from the last addition, add it to carry
            int sum = carry;
            if (i >= 0) {
                //we subtract '0' to get the int value of the char from the ascii
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            //if sum==2 we have a carry, else no carry 1/2 rounds down to 0 in integer arithematic
            carry = sum >> 1;
            // if sum==2 or sum==0 append 0 cause 1+1=0 in this case as
            // this is base 2 (just like 1+9 is 0 if adding ints in columns)
            sb.append(sum & 1);
        }
        if (carry != 0) {
            //leftover carry, add it
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
