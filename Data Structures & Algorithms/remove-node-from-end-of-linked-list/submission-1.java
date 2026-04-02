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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;

        while (n > 0) {
            head = head.next;
            n--;
        }

        while (head != null) {
            head = head.next;
            previous = previous.next;
        }

        previous.next = previous.next.next;

        return dummy.next;
    }
}
