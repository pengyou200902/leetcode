package algorithm.LinkedList.p1290;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-09 15:29
 */
public class Solution {
    public int getDecimalValue(ListNode head) {
        // System.out.println(head.val);
        ListNode pre = head;
        while (pre != null) {
            if (pre.val == 1)   break;
            pre = pre.next;
        }

        if (pre == null) return 0;

        int num = 1;
        while (pre.next != null) {
            num <<= 1;
            if (pre.next.val == 1)   num += 1;
            pre = pre.next;
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
