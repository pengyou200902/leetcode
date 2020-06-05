package algorithm.UnCategorized.p23;

import utils.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1)   return null;
        else if (lists.length == 1)   return lists[0];
        int delta = 1;
        while (delta < lists.length){
            int tmp = delta + delta;
            for (int i = 0; i < lists.length - delta; i += tmp) {
                lists[i] = mergeTwoLists(lists[i], lists[i + delta]);
            }
            delta = tmp;
        }
        return lists[0];
//        ListNode two = mergeTwoLists(lists[0], lists[1]);
//        for (int i = 2; i < lists.length; i++) {
//            two = mergeTwoLists(two, lists[i]);
//        }
//        return two;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)  return l2;
        else if(l2 == null)  return l1;
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
