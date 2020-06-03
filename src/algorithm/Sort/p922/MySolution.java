package algorithm.Sort.p922;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author Friende.Peng_You
 * @Date 2020-05-30 21:14
 */
public class MySolution {
    public int[] sortArrayByParityII(int[] A) {
        HashSet<Integer> checked = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (checked.contains(i))    continue;
            if (i % 2 == 0 && A[i] % 2 != 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (checked.contains(j))    continue;
                    if (j % 2 != 0 && A[j] % 2 == 0) {
                        A[i] ^= A[j];
                        A[j] = A[i] ^ A[j];
                        A[i] ^= A[j];
                        checked.add(i);
                        checked.add(j);
                        break;
                    }
                }
            }
            else if (i % 2 != 0 && A[i] % 2 == 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (checked.contains(j))    continue;
                    if (j % 2 == 0 && A[j] % 2 != 0) {
                        A[i] ^= A[j];
                        A[j] = A[i] ^ A[j];
                        A[i] ^= A[j];
                        checked.add(i);
                        checked.add(j);
                        break;
                    }
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        MySolution s = new MySolution();
        int[] x = {4, 2, 5, 7};
        System.out.println(Arrays.toString(s.sortArrayByParityII(x)));
    }
}
