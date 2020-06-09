package algorithm.LinkedList.p876;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-09 16:15
 * @Reference https://leetcode.com/problems/middle-of-the-linked-list/discuss/154619/C%2B%2BJavaPython-Slow-and-Fast-Pointers
 * Each time, slow go 1 steps while fast go 2 steps.
 * When fast arrives at the end, slow will arrive right in the middle.
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null)   return null;
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
