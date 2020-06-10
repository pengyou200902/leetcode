package algorithm.LinkedList.p83;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-10 21:16
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // ListNode tmp = curr.next;
                curr.next = curr.next.next;
                // tmp = null;
                // System.gc();
                continue;
            }
            curr = curr.next;
        }
        return head;
    }
}
