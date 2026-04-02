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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;
        ListNode group = dummy;
        while (group != null) {
            for (int i = 0; i < k && group != null; i++) {
                group = group.next;
            }

            if (group != null) {
                ListNode next = group == null ? null : group.next;

                if (group != null) {
                    group.next = null;
                }
                ListNode nextPrevious = previous.next;
                previous.next = reverse(previous.next);
                nextPrevious.next = next;
                group = nextPrevious;
                previous = nextPrevious;
            }
        }

        return dummy.next;
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
}
