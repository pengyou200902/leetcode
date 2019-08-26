package algorithm.p24;

import utils.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null)   return null;
        else if (head.next == null) return head;
        ListNode prev, cur, tmp;
        ListNode ans = head.next;
        prev = head;
        cur = ans;
        if (ans.next == null) {
            prev.next = null;
            ans.next = prev;
        }
//        tmp = cur.next;
//        prev.next = tmp;
//        cur.next = prev;
        else {
            while (true) {
                tmp = cur.next;
                prev.next = tmp.next;
                cur.next = prev;
                if (tmp.next == null) {
                    prev.next = tmp;
                    break;
                }
                cur = tmp.next;
                prev = tmp;

                if (cur.next == null) {
                    cur.next = prev;
                    prev.next = null;
                    break;
                }
            }
        }

        return ans;
    }
}
