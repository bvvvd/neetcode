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

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode preMid = findPreMid(head);
        ListNode right = preMid.next;
        preMid.next = null;

        merge(head, reverse(right));
    }

    private ListNode findPreMid(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;

        while (head != null && head.next != null) {
            head = head.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode runner = dummy;

        while (left != null || right != null) {
            if (left != null) {
                runner.next = left;
                runner = runner.next;
                left = left.next;
            }
            if (right != null) {
                runner.next = right;
                runner = runner.next;
                right = right.next;
            }
        }

        return dummy.next;
    }
}
