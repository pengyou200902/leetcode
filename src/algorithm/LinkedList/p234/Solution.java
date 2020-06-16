package algorithm.LinkedList.p234;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-16 19:11
 * @Reference https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)  {return true;}
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the List from slow to the end
        ListNode halfHead = reverse(slow);
        // start judging
        ListNode curr = head;
        while (halfHead != null && curr != null) {
            if (curr.val != halfHead.val) {
                return false;
            }
            halfHead = halfHead.next;
            curr = curr.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)  {return head;}
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
