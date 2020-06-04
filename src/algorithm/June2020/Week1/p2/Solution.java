package algorithm.June2020.Week1.p2;

import utils.ListNode;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-04 22:57
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
