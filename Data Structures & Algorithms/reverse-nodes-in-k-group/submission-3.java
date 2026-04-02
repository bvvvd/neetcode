class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;
        ListNode groupTail = dummy;

        while (groupTail != null) {
            for (int i = 0; i < k && groupTail != null; i++) {
                groupTail = groupTail.next;
            }

            if (groupTail == null) {
                break;
            }

            ListNode groupNext = groupTail.next;
            groupTail.next = null;

            ListNode oldGroupHead = previous.next;
            previous.next = reverse(oldGroupHead);
            oldGroupHead.next = groupNext;

            previous = oldGroupHead;
            groupTail = oldGroupHead;
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