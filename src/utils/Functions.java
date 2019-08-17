package utils;

public class Functions {
    public static ListNode genSinglyListedNodes(int[] vals) {
        if (vals.length == 0)   return null;
        ListNode head = new ListNode(vals[0]);
        ListNode cur = head;
        for (int i = 1; i < vals.length; i++) {
            cur.next = new ListNode(vals[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printSinglyListedNodes(ListNode head) {
        if (head == null)   return;
        while (head.next != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.printf("%d\n", head.val);
    }
}
