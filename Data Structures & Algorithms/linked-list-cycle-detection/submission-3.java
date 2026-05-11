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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;

        while (head != null && head.next != null) {
            slow = slow.next;
            head = head.next.next;

            if (slow == head) {
                return true;
            }
        }

        return false;
    }
}
