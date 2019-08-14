package algorithm.p19;

import utils.ListNode;

public class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode cur;
        int len = 0;
        for(cur = head;cur != null;cur = cur.next) {
            len++;
        }
        len -= n;
        for(cur = tmp;len > 0;cur = cur.next, len--);
        cur.next = cur.next.next;
        return head;
    }
}


