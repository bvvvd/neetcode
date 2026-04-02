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
        ListNode dummy = new ListNode(0, head);
        ListNode segmentPrevious = dummy;

        while (true) {
            ListNode segmentTail = getKthNode(segmentPrevious, k);
            if (segmentTail == null) {
                break;
            }

            ListNode nextSegmentHead = segmentTail.next;

            ListNode previous = nextSegmentHead;
            ListNode current = segmentPrevious.next;
            while (current != nextSegmentHead) {
                ListNode next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            ListNode oldGroupStart = segmentPrevious.next;
            segmentPrevious.next = segmentTail;
            segmentPrevious = oldGroupStart;
        }
        
        return dummy.next;
    }

    private ListNode getKthNode(ListNode head, int k) {
        while (head != null && k > 0) {
            head = head.next;
            k--;
        }
        return head;
    }
}
