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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode preReversed = dummy;
        while (left > 1) {
            head = head.next;
            preReversed = preReversed.next;
            left--;
            right--;
        }

        ListNode previous = null;
        ListNode reverseTail = preReversed.next;
        while (right > 0) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
            right--;
        }

        preReversed.next = previous;
        reverseTail.next = head;

        return dummy.next;
    }
}