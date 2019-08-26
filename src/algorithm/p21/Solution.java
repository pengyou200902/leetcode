package algorithm.p21;

import utils.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode first;
        if (l1.val <= l2.val) {
            first = l1;
            first.next = mergeTwoLists(l1.next, l2);
        }
        else {
            first = l2;
            first.next = mergeTwoLists(l1, l2.next);
        }
        return first;
    }



}
