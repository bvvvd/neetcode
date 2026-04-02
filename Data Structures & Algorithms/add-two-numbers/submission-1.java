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
    public ListNode addTwoNumbers(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carry = 0;

        while (left != null || right != null) {
            int l = left == null ? 0 : left.val;
            left = left == null ? null : left.next;
            int r = right == null ? 0 : right.val;
            right = right == null ? null : right.next;

            int sum = l + r + carry;
            ListNode newNode = new ListNode(sum % 10);
            carry = sum / 10;
            current.next = newNode;
            current = current.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
