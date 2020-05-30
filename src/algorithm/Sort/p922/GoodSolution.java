package algorithm.Sort.p922;

import java.util.Arrays;

/**
 * @Author Friende.Peng_You
 * @Date 2020-05-30 21:36
 * @Ref https://leetcode.com/problems/sort-array-by-parity-ii/discuss/181160/Java-two-pointer-one-pass-inplace
 */
public class GoodSolution {
    // i records even positions, j records odd positions
    // i and j will start going until they find
    // A[i] or A[j] is on a wrong position. Then they will stop
    // and swap A[i] and A[j].
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, n = A.length;
        while(i < n && j < n) {
            while (i < n && (A[i] & 1) == 0) {
                i += 2;
            }
            while (j < n && (A[j] & 1) == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                // Swap A[i] and A[j]
//                int temp = A[i];
//                A[i] = A[j];
//                A[j] = temp;
                A[i] ^= A[j];
                A[j] = A[i] ^ A[j];
                A[i] ^= A[j];
            }
            else break;
        }
        return A;
    }

    public static void main(String[] args) {
        GoodSolution s = new GoodSolution();
        int[] x = {4, 2, 5, 7};
        System.out.println(Arrays.toString(s.sortArrayByParityII(x)));
    }
}
