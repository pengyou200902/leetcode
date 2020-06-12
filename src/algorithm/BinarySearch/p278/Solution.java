package algorithm.BinarySearch.p278;


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import utils.VersionControl;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-12 14:37
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n < 1)  throw new IllegalArgumentException();
//        else if (n == 1 && isBadVersion(n)) return n;
        int mid = 0;
        int low = 1, high = n;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
