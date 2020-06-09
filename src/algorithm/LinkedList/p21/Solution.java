package algorithm.LinkedList.p21;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-09 21:42
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l2 == null) return l1;
        else if (l1 == null) return l2;

        ListNode curr;
        ListNode tmp;
        ListNode n1 = new ListNode(-1);
        n1.next = l1;
        curr = n1;
        while (l2 != null) {
            if (curr.next == null) {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if (curr.next.val > l2.val) {
                tmp = curr.next;
                curr.next = new ListNode(l2.val);
                curr.next.next = tmp;
                l2 = l2.next;
            }
            else {
                curr = curr.next;
            }
        }
        return n1.next;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
