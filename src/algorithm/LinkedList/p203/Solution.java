package algorithm.LinkedList.p203;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-16 16:21
 */
public class Solution {
    // 速度较快
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)   {return null;}

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return head;
    }

     public ListNode removeElements2(ListNode head, int val) {
         if (head == null)   {return null;}
         ListNode dummy = new ListNode(-1);
         dummy.next = head;
         ListNode curr = head;
         ListNode pre = dummy;
         while (curr != null) {
             if (curr.val == val) {
                 pre.next = curr.next;
             }
             else {
                 pre = curr;
             }
             curr = curr.next;
         }
         return dummy.next;
     }
}
