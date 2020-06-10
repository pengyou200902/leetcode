package algorithm.LinkedList.p141;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-10 21:17
 * @Reference https://leetcode.com/problems/linked-list-cycle/discuss/44489/O(1)-Space-Solution
 * 快慢指针
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)   return true;
        }
        return false;
    }
}
