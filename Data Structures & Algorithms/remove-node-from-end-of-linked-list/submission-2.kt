/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var fast: ListNode? = dummy
        var offset = n
        while (fast != null && offset >= 0) {
            fast = fast.next
            offset--
        }
        var slow: ListNode? = dummy
        while (fast != null) {
            fast = fast.next
            slow = slow?.next
        }

        slow?.next = slow?.next?.next
 
        return dummy?.next
    }
}
