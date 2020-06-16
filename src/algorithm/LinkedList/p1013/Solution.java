package algorithm.LinkedList.p1013;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-16 22:35
 * @Reference https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/265508/JavaC%2B%2BPython-Next-Greater-Element
 * @Reference https://leetcode.com/problems/next-greater-node-in-linked-list/discuss/290114/Java-one-pass-O(n)-time-O(n)-space-code-with-comments-%3A)
 */
public class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null)   {return null;}
        if (head.next == null)   {return new int[]{0};}

        Deque<Integer> stack = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            arr.add(node.val);
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            // 把未找到next large的val对应的坐标全部存入stack，
            // 比如递减的4,3,2,1，对应坐标0,1,2,3入栈，假如此时i=4的val是5
            // 那么在while循环里pop栈里所有的index，并在ans中把这些index
            // 对应的值都变成5
            while (!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)) {
                ans[stack.pop()] = arr.get(i);
            }
            stack.push(i);
        }
        return ans;
    }
}
