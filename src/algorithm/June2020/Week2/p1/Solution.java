package algorithm.June2020.Week2.p1;

import java.util.Arrays;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-08 22:27
 */
public class Solution {

    private int[] twoPower = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536,
                              131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864,
                              134217728, 268435456, 536870912, 1073741824};

    public boolean isPowerOfTwo(int n) {
        for (int x : twoPower) {
            if ((x ^ n) == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] s = new int[32];
        s[0] = 1;
        for (int i = 1; i < s.length; i++) {
            s[i] = s[i - 1] * 2;
        }
//        s[s.length-1] -= 1;
        System.out.println(Arrays.toString(s));
//        [1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, -2147483648]
    }
}
