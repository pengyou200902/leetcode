package algorithm.UnCategorized.p6;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 1) return "";
        else if (numRows == 1) return s;
        else if (numRows >= s.length()) return s;
        int j, count;
        int z = 0;
        int[][] idxs = new int[s.length()][2];
        StringBuilder sb = new StringBuilder();
        for (j = 0, count = 0; count < s.length();j++) {
            if (j % (numRows - 1) == 0) {
                z = 0;
                for (int i = 0; count < s.length() && i < numRows; i++, count++) {
                    idxs[count][0] = i;
                    idxs[count][1] = j;
                }
            }
            else {
                idxs[count][0] = numRows - 2 - z;
                idxs[count][1] = j;
                z++;
                count++;
            }
        }
        char[][] res = new char[numRows][j];
        for (count = 0; count < s.length(); count++) {
            res[idxs[count][0]][idxs[count][1]] = s.charAt(count);
        }
        for (int i = 0; i < numRows; i++) {
            for (int k = 0; k < j; k++) {
                if (res[i][k] != '\0') {
                    sb.append(res[i][k]);
                    System.out.printf("%c ", res[i][k]);
                }
                else System.out.print("  ");
            }
            System.out.println();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(new Solution().convert(s, 3));
    }
}
