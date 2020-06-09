package algorithm.LinkedList.p206;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-09 16:35
 */
public class Solution {
    // 循环解法
    public ListNode reverseList(ListNode head) {
        ListNode tmp = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = tmp;
            tmp = head;
            head = next;    //不可 head = head.next; 因为上方已经修改过 head.next 的值
        }
        return tmp;
    }

//     递归解法
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null)  return head;
//         return reverseListInt(null, head);
//     }

//     public ListNode reverseListInt(ListNode pre, ListNode node) {
//         if (node.next == null) {
//             node.next = pre;
//             return node;
//         }

//         ListNode tmp = node.next;
//         node.next = pre;
//         // pre.next = null;
//         return reverseListInt(node, tmp);
//     }
}
