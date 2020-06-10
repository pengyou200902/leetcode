package algorithm.LinkedList.p82;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-10 17:12
 * @Reference https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/28335/My-accepted-Java-code
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)  return head;

        ListNode curr = head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;  // 等效于 prev.next = curr;
        while (curr != null) {
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            if (prev.next == curr) {
                // 说明没有发生重复
                prev = prev.next;
            }
            else {
                // 说明发现重复并且删掉了，目前curr就是指向删剩下的最后一个重复值，
                // 让prev.next = curr.next，直接跳过最后这个重复值，这样就把一种重复值删完了
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
