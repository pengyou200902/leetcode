package algorithm.LinkedList.p203;

import utils.ListNode;

import java.util.Random;

/**
 * @Author Friende.Peng_You
 * @Date 2020-06-16 16:39
 */
public class TestSolution {

    Random random;
    Solution solution;

    TestSolution() {
        random = new Random();
        solution = new Solution();
    }

    ListNode getRandomLinkedList(int size) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int i = 0; i < size; i++) {
            curr.next = new ListNode(random.nextInt());
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int testSize = 50000000;
        TestSolution testSolution = new TestSolution();
        int val = testSolution.random.nextInt();
        ListNode head = testSolution.getRandomLinkedList(testSize);
        long start, end;
        start = System.currentTimeMillis();
        testSolution.solution.removeElements(head, val);
        end = System.currentTimeMillis();
        System.out.printf("removeElements %d ms\n", end - start);
        start = System.currentTimeMillis();
        testSolution.solution.removeElements2(head, val);
        end = System.currentTimeMillis();
        System.out.printf("removeElements2 %d ms\n", end - start);
    }
}
