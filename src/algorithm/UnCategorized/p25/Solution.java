package algorithm.UnCategorized.p25;

import utils.ListNode;
import utils.Functions;
/*
    Exceeds Memory Limit
    超出内存
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2 || head.next == null)   return head;
        ListNode prevTail = head, p1 = head;
        int count = 1;
        boolean changeHead = true;
        while (reversable(p1, k)) {
            ListNode p2, p3 = null;
            if (!changeHead)    prevTail.next = p1;
            for (count = 1, p2 = p1.next;
                 p2 != null && count < k;
                 count++
            ) {
                if (count == k - 1) {
                    prevTail = p1;
//                    break;
                }
                p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;

            }
            if (changeHead) {
                head.next = p3;
                head = p1;
                changeHead = false;
            }
//            else {
//                prevTail.next = p1;
//            }
            p1 = p3;
        }
        return head;
    }

    public static boolean reversable(ListNode head, int k) {
        if (head == null)   return false;
        int count = 0;
//        ListNode cur = head;
        while(head != null && count < k) {
            count++;
            head = head.next;
        }
        return count == k;
    }

    public static void main(String[] args) {
        int[] vals = new int[]{1,2,3,4,5};
        ListNode head = Functions.genSinglyListedNodes(vals);
        Functions.printSinglyListedNodes(head);
        head = new Solution().reverseKGroup(head, 2);
        Functions.printSinglyListedNodes(head);
    }
}
