/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current: ListNode? = head
        while (current != null) {
            val next: ListNode? = current.next
            current.next = previous
            previous = current
            current = next
        }

        return previous
    }
}
